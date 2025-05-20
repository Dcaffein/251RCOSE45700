package CanvasApp.View.CanvasView;

import CanvasApp.View.CanvasView.EventHandler.CanvasDataEventHandler;
import CanvasApp.View.PropertyView.PropertyView;
import CanvasApp.View.ShapeView.ShapeView;
import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.Command.CreateShapeCmd.CompleteCreateCmd;
import CanvasApp.ViewModel.Data.CanvasData.CanvasData;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;
import Command.Command;
import static utils.MathUtil.computeRectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CanvasView extends JPanel implements CanvasViewContext {
    private final CanvasVM viewModel;
    private final CanvasData canvasData;
    private final CanvasDataEventHandler canvasDataEventHandler = new CanvasDataEventHandler(this);

    private final JLayeredPane layeredPane = new JLayeredPane();
    private final JPanel glassPane = new JPanel();
    private final PropertyView propertyView;  // Property inspector panel on the right
    private Point dragStart = null;

    public CanvasView(CanvasVM viewModel, CanvasData canvasData) {
        this.viewModel = viewModel;
        this.canvasData = canvasData;
        canvasData.attach(canvasDataEventHandler);

        this.propertyView = new PropertyView(viewModel, viewModel.getPropertyData());

        setLayout(new BorderLayout());
        initUI();
        initGlassPane();
    }

    private void initUI() {
        layeredPane.setPreferredSize(new Dimension(800, 600));
        layeredPane.setLayout(null);
        JScrollPane canvasScroll = new JScrollPane(layeredPane);

        JSplitPane splitPane = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                canvasScroll,
                propertyView
        );
        splitPane.setDividerLocation(800);
        splitPane.setResizeWeight(0.0);

        add(splitPane, BorderLayout.CENTER);
    }

    private void initGlassPane() {
        // add a transparent glass pane for drawing new shapes
        glassPane.setBounds(0, 0, layeredPane.getPreferredSize().width, layeredPane.getPreferredSize().height);
        glassPane.setOpaque(false);
        glassPane.setVisible(false);
        layeredPane.add(glassPane, JLayeredPane.DRAG_LAYER);  // add to drag layer

        glassPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                dragStart = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Point dragEnd = e.getPoint();
                Rectangle dragRect = computeRectangle(dragStart, dragEnd);
                Command cmd = new CompleteCreateCmd(
                        viewModel, dragRect.x, dragRect.y,
                        dragRect.width, dragRect.height,
                        canvasData.getMaxZ() + 1
                );
                viewModel.handleCmd(cmd);
            }
        });
    }

    public ShapeView createChildShapeView(ShapeData shapeData) {
        return shapeData.getFactory().createShapeView(shapeData, viewModel);
    }

    public void addChildViewOnLayeredPane(Component child){
        layeredPane.add(child);
    }

    public void removeChildViewOnLayeredPane(Component child) {
        layeredPane.remove(child);
        child.repaint();
    }

    public void setChildViewLayerOnLayeredPane(Component child,int layer){
        layeredPane.setLayer(child, layer);
    }

    public void setGlassPaneVisible(boolean isVisible){
        glassPane.setVisible(isVisible);
    }

    public Component findComponentById(String id) {
        for (Component comp : layeredPane.getComponents()) {
            if (id.equals(comp.getName())) {
                return comp;
            }
        }
        return null;
    }
}

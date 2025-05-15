package CanvasApp.View.CanvasView;

import CanvasApp.View.PropertyView.PropertyView;
import CanvasApp.View.ShapeView.ShapeView;
import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.Command.CreateShapeCmd.CompleteCreateCmd;
import CanvasApp.ViewModel.Datas.CanvasData.CanvasData;
import CanvasApp.ViewModel.Datas.CanvasData.Event.*;
import CanvasApp.ViewModel.Datas.PropertyData.PropertyData;
import CanvasApp.ViewModel.Datas.ShapeData.ShapeData;
import Command.Command;
import static utils.MathUtil.computeRectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Main canvas panel with property inspector on the right.
 */
public class CanvasView extends JPanel implements CanvasDataObserver {
    private final CanvasVM viewModel;
    private final CanvasData canvasData;
    private final JLayeredPane layeredPane = new JLayeredPane();
    private final JPanel glassPane = new JPanel();
    private final PropertyView propertyView;  // Property inspector panel on the right
    private Point dragStart = null;

    public CanvasView(CanvasVM viewModel, CanvasData canvasData) {
        this.viewModel = viewModel;
        this.canvasData = canvasData;
        this.propertyView = new PropertyView(viewModel, viewModel.getPropertyData());  // instantiate PropertyView

        canvasData.attach(this);
        setLayout(new BorderLayout());  // switched from null layout to BorderLayout for split pane
        initUI();  // initialize canvas and property view layout
        initGlassPane();  // initialize drawing glass pane
    }

    private void initUI() {
        // wrap canvas pane in scroll pane
        layeredPane.setPreferredSize(new Dimension(800, 600));
        layeredPane.setLayout(null);
        JScrollPane canvasScroll = new JScrollPane(layeredPane);

        // split pane to place canvas on left and properties on right
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

    @Override
    public void onShapeAdded(CanvasDataShapeAdded event) {
        String id = event.source.getId();
        ShapeData shapeData = canvasData.getShapeData(id);
        ShapeView shapeView = event.shapeFactory.createShapeView(shapeData, viewModel);
        layeredPane.add(shapeView);
        layeredPane.setLayer(shapeView, shapeData.getZ());
        shapeView.repaint();
        System.out.println("[CanvasView] CanvasView add shapeView="
                + shapeView.getName());
    }

    @Override
    public void onShapeRemoved(CanvasDataShapeRemoved event) {
        Component component = findComponentById(event.source.getId());
        if (component != null) {
            layeredPane.remove(component);
        }
    }

    @Override
    public void onRealigned(CanvasDataShapeRealigned event) {
        Component component = findComponentById(event.source.getId());
        if (component != null) {
            layeredPane.setLayer(component, event.source.getZ());
        }
    }

    @Override
    public void onCanvasDataDraggableSet(CanvasDataDraggableSet event) {
        glassPane.setVisible(event.source.isDraggable());
    }

    private Component findComponentById(String id) {
        for (Component comp : layeredPane.getComponents()) {
            if (id.equals(comp.getName())) {
                return comp;
            }
        }
        return null;
    }
}

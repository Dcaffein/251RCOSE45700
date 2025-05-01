package CanvasApp.View.CanvasView;

import CanvasApp.View.ShapeView.ShapeView;
import CanvasApp.ViewModel.CanvasData.Observer.*;
import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.CanvasData.CanvasData;
import CanvasApp.ViewModel.Command.CreateShapeCmd;
import CanvasApp.ViewModel.ShapeData.ShapeData;
import Command.Command;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static utils.MathUtil.computeRectangle;

public class CanvasView extends JPanel implements CanvasDataObserver {
    private final CanvasVM viewModel;
    private final CanvasData canvasData;
    private final JTextField zField = new JTextField();
    private final JLayeredPane layeredPane = new JLayeredPane();
    private final JPanel glassPane = new JPanel();
    private Point dragStart = null;

    public CanvasView(CanvasVM viewModel, CanvasData canvasData) {
        this.viewModel = viewModel;
        this.canvasData = canvasData;
        canvasData.attach(this);
        setLayout(null);
        initUI();
        initGlassPane();
    }

    private void initUI() {
        layeredPane.setBounds(0, 0, 800, 600);
        layeredPane.setLayout(null);
        this.add(layeredPane);
        layeredPane.add(glassPane, JLayeredPane.DRAG_LAYER);

        zField.setBounds(120, 50, 50, 25);
        zField.addActionListener(e -> {
            String zText = zField.getText().trim();
            try {
                int newZ = Integer.parseInt(zText);
                viewModel.realign(newZ);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "숫자를 입력하세요!");
            }
        });

        this.add(zField);
    }

    private void initGlassPane() {
        glassPane.setBounds(0, 0, layeredPane.getWidth(), layeredPane.getHeight());
        glassPane.setOpaque(false);
        glassPane.setVisible(false);

        glassPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                dragStart = e.getPoint();
                System.out.println("[CanvasView] mousePressed: " + dragStart);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Point dragEnd = e.getPoint();
                System.out.println("[CanvasView] mouseReleased: " + dragEnd);
                Rectangle dragRect = computeRectangle(dragStart, dragEnd);
                System.out.println("[CanvasView] computed dragRect: " + dragRect);
                Command createCmd = new CreateShapeCmd(viewModel, dragRect.x, dragRect.y, dragRect.width, dragRect.height, canvasData.getMaxZ() + 1);
                viewModel.handleCmd(createCmd);
            }
        });

    }

    public Component findComponentById(String id) {
        for (Component comp : layeredPane.getComponents()) {
            if (id.equals(comp.getName())) {
                return comp;
            }
        }
        return null;
    }

    @Override
    public void onShapeAdded(CanvasDataShapeAdded event) {
        System.out.println("[CanvasView] onShapeAdded: id=" + event.id);
        ShapeData shapeData = canvasData.getShapeData(event.id);
        ShapeView shapeView = event.shapeFactory.createShapeView(shapeData, viewModel);
        layeredPane.add(shapeView);
        layeredPane.setLayer(shapeView, shapeData.getZ());
        shapeView.repaint();
        System.out.println("[CanvasView] shapeView added to layeredPane: z=" + shapeData.getZ());
    }


    @Override
    public void onShapeRemoved(CanvasDataShapeRemoved event) {
        Component component = findComponentById(event.id);
        layeredPane.remove(component);
    }

    @Override
    public void onRealigned(CanvasDataShapeRealigned event) {
        Component component = findComponentById(event.id);
        layeredPane.setLayer(component, event.z);
    }

    @Override
    public void onCanvasDataDraggableSet(CanvasDataDraggableSet event) {
        System.out.println("[CanvasView] onCanvasDataDraggableSet: " + event.draggable);
        setGlassVisible(event.draggable);
    }

    public void setGlassVisible(boolean glassVisible) {
        System.out.println("[CanvasView] setGlassVisible = " + glassVisible);
        glassPane.setVisible(glassVisible);
    }

}

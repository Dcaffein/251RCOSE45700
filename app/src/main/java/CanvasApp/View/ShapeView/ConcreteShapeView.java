package CanvasApp.View.ShapeView;

import CanvasApp.View.ShapeView.EventHandler.ShapeDataEventHandler;
import CanvasApp.View.ShapeView.ShapeViewState.IsReadyToSelect;
import CanvasApp.View.ShapeView.ShapeViewState.ShapeViewState;
import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.Command.ShapeCmd.*;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;
import Command.Command;

import java.awt.*;
import java.awt.event.*;

public abstract class ConcreteShapeView extends ShapeView implements ShapeViewContext {
    protected Point dragStart = null;
    protected ShapeViewState currentState = new IsReadyToSelect(this);

    public ConcreteShapeView(ShapeData shapeData, CanvasVM viewModel) {
        super(shapeData, viewModel);
        this.setName(shapeData.getId());
        this.shapeDataEventHandler = new ShapeDataEventHandler(this);
        shapeData.attach(shapeDataEventHandler);

        setBounds(shapeData.getX(), shapeData.getY(), shapeData.getW(), shapeData.getH());

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                currentState.onMousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                currentState.onMouseReleased(e);
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                currentState.onMouseDragged(e);
            }
        });

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                System.out.println("componentResized : " + e.getComponent().getClass().getName());
                for (Component comp : ConcreteShapeView.this.getComponents()) {
                    comp.setBounds(0, 0, e.getComponent().getWidth(), e.getComponent().getHeight());
                    comp.repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void setCurrentState(ShapeViewState newState) {
        currentState = newState;
    }

    public boolean isCorner(Point p) {
        int w = getWidth();
        int h = getHeight();
        int handleSize  = 10;
        return (p.x >= w - handleSize  && p.y >= h - handleSize );
    }

    public void select(String id) {
        viewModel.handleCmd(new Select(id,viewModel));
    }

    public void multiSelect(String id) {
        viewModel.handleCmd(new MultiSelect(id,viewModel));
    }

    public String getId(){
        return shapeData.getId();
    }

    public Point getDragStart() {
        return dragStart;
    }

    public void setDragStart(Point p) {
        dragStart = p;
    }

    @Override
    public void resizeShape(int dw,int dh){
        Command resizeCmd = new ResizeByDrag(viewModel,dw, dh);
        viewModel.handleCmd(resizeCmd);
    }

    @Override
    public void moveShape(int dx, int dy) {
        Command moveCmd = new MoveByDrag(viewModel,dx, dy);
        viewModel.handleCmd(moveCmd);
    }
}

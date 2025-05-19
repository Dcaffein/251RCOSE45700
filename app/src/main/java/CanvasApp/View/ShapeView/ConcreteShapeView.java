package CanvasApp.View.ShapeView;

import CanvasApp.View.ShapeView.EventHandler.ShapeDataEventHandler;
import CanvasApp.View.ShapeView.ShapeViewState.IsReadyToSelect;
import CanvasApp.View.ShapeView.ShapeViewState.ShapeViewState;
import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.Command.ShapeCmd.Move;
import CanvasApp.ViewModel.Command.ShapeCmd.MultiSelect;
import CanvasApp.ViewModel.Command.ShapeCmd.Resize;
import CanvasApp.ViewModel.Command.ShapeCmd.Select;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;
import Command.Command;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

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
        Command resizeCmd = new Resize(viewModel,shapeData.getW()+dw, shapeData.getH()+dh);
        viewModel.handleCmd(resizeCmd);
    }

    @Override
    public void moveShape(int dx, int dy) {
        Command moveCmd = new Move(viewModel,shapeData.getX()+dx, shapeData.getY()+dy);
        viewModel.handleCmd(moveCmd);
    }
}

package CanvasApp.View.ShapeView;

import CanvasApp.View.ShapeView.ShapeViewState.IsReadyToSelect;
import CanvasApp.View.ShapeView.ShapeViewState.ShapeViewContext;
import CanvasApp.View.ShapeView.ShapeViewState.ShapeViewState;
import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.ShapeData.Observer.ShapeDataMoved;
import CanvasApp.ViewModel.ShapeData.Observer.ShapeDataObserver;
import CanvasApp.ViewModel.ShapeData.Observer.ShapeDataResized;
import CanvasApp.ViewModel.ShapeData.ReadOnlyShapeData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public abstract class ShapeView extends JComponent implements ShapeDataObserver, ShapeViewContext {
    protected final ReadOnlyShapeData shapeData;
    protected final CanvasVM viewModel;

    protected Point dragStart = null;
    protected ShapeViewState currentState = new IsReadyToSelect(this);

    public ShapeView(ReadOnlyShapeData shapeData, CanvasVM viewModel ) {
        this.shapeData = shapeData;
        this.viewModel = viewModel;
        this.shapeData.attach(this);
        this.setName(shapeData.getId());
        setBounds(shapeData.getX(), shapeData.getY(), shapeData.getW(), shapeData.getH());
        System.out.println("[ShapeView] setBounds at creation: " + getBounds());

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
    public void onMoved(ShapeDataMoved event) {
        setBounds(event.x,event.y,shapeData.getW(),shapeData.getH());
    }

    @Override
    public void onResized(ShapeDataResized event) {
        setBounds(shapeData.getX(),shapeData.getY(),event.w,event.h);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public abstract void draw(Graphics g);

    public void setCurrentState(ShapeViewState newState) {
        currentState = newState;
    }

    public boolean isCorner(Point p) {
        int w = getWidth();
        int h = getHeight();
        int handleSize  = 10;
        return (p.x >= w - handleSize  && p.y >= h - handleSize );
    }


    @Override
    public void select(String id) {
        viewModel.select(id);
    }

    @Override
    public void multiSelect(String id) {
        viewModel.multiSelect(id);
    }

    @Override
    public String getId(){
        return shapeData.getId();
    }

    @Override
    public Point getDragStart() {
        return dragStart;
    }

    @Override
    public void setDragStart(Point p) {
        dragStart = p;
    }

    @Override
    public void resizeShape(int dw,int dh){
        viewModel.resize(dw,dh);
    }

    @Override
    public void moveShape(int dx, int dy) {
        viewModel.move(dx, dy);
    }
}

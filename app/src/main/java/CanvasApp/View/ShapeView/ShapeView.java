package CanvasApp.View.ShapeView;

import CanvasApp.View.ShapeView.ShapeViewState.IsReadyToSelect;
import CanvasApp.View.ShapeView.ShapeViewState.ShapeViewContext;
import CanvasApp.View.ShapeView.ShapeViewState.ShapeViewState;
import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.Command.ShapeCmd.Move;
import CanvasApp.ViewModel.Command.ShapeCmd.MultiSelect;
import CanvasApp.ViewModel.Command.ShapeCmd.Resize;
import CanvasApp.ViewModel.Command.ShapeCmd.Select;
import CanvasApp.ViewModel.Datas.ShapeData.Event.ShapeDataMoved;
import CanvasApp.ViewModel.Datas.ShapeData.Event.ShapeDataObserver;
import CanvasApp.ViewModel.Datas.ShapeData.Event.ShapeDataRealigned;
import CanvasApp.ViewModel.Datas.ShapeData.Event.ShapeDataResized;
import CanvasApp.ViewModel.Datas.ShapeData.ReadOnlyShapeData;

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
        setBounds(event.source.getX(), event.source.getY(),shapeData.getW(),shapeData.getH());
    }

    @Override
    public void onResized(ShapeDataResized event) {
        setBounds(shapeData.getX(),shapeData.getY(),event.source.getW(),event.source.getH());
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
        viewModel.handleCmd(new Select(id,viewModel));
    }

    @Override
    public void multiSelect(String id) {
        viewModel.handleCmd(new MultiSelect(id,viewModel));
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
        viewModel.handleCmd(new Resize(viewModel,shapeData.getW()+dw, shapeData.getH()+dh));
    }

    @Override
    public void moveShape(int dx, int dy) {
        viewModel.handleCmd(new Move(viewModel,shapeData.getX()+dx, shapeData.getY()+dy));
    }

    @Override
    public void onRealigned(ShapeDataRealigned event){

    }
}

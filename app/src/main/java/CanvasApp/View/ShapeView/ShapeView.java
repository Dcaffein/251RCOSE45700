package CanvasApp.View.ShapeView;

import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataObserver;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

import javax.swing.*;
import java.awt.*;

public abstract class ShapeView extends JComponent{
    protected final ShapeData shapeData;
    protected final CanvasVM viewModel;
    protected ShapeDataObserver shapeDataEventHandler;

    public ShapeView(ShapeData shapeData, CanvasVM viewModel ) {
        this.shapeData = shapeData;
        this.viewModel = viewModel;
        setLayout(null);
    }

    public abstract void draw(Graphics g);

    public abstract String getId();

    public abstract void resizeShape(int dw,int dh);

    public abstract void moveShape(int dx, int dy);

    public ShapeData getShapeData() {
        return shapeData;
    }

    public abstract Shape getShape();
}

package CanvasApp.View.ShapeView.Drawer;

import CanvasApp.View.ShapeView.ShapeView;

import java.awt.*;

public abstract class Drawer {
    public Drawer decorated;
    public abstract void draw(Graphics g, ShapeView shapeView);
    public abstract Shape getShape(ShapeView shapeView);
//    public void setDecorated(Drawer decorated) {
//        this.decorated = decorated;
//    }
}

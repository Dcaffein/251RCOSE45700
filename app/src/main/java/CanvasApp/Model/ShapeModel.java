package CanvasApp.Model;

import Observer.Observable;

import java.util.List;

public abstract class ShapeModel extends Observable{
    protected final int minimum = 20;
    public abstract String getId();
    public abstract int getX();
    public abstract int getY();
    public abstract int getW();
    public abstract int getH();
    public abstract int getZ();
    public abstract void moveBy(int dx, int dy);
    public abstract void resizeBy(int dw, int dh);
    public abstract void moveTo(int x, int y);
    public abstract void resizeAs(int w, int h);
    public abstract void realign(int z);
    public abstract void addChild(ShapeModel shapeModel);
    public abstract void removeChild(ShapeModel shapeModel);
    public abstract void replace(ShapeModel oldOne,ShapeModel newOne);
    public abstract void clear();
    public abstract List<ShapeModel> getChildren();
    public abstract ShapeModel getChild(String id);
}

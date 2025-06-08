package CanvasApp.Model;

import Observer.Observable;

import java.util.Collection;

public abstract class ShapeModel extends Observable{
    protected final int minimum = 20;
    public abstract String getId();
    public abstract int getX();
    public abstract int getY();
    public abstract int getW();
    public abstract int getH();
    public abstract int getZ();
    public abstract void setPositionBy(int dx, int dy);
    public abstract void setSizeBy(int dw, int dh);
    public abstract void setPosition(int x, int y);
    public abstract void setSize(int w, int h);
    public abstract void realign(int z);
    public abstract void add(ShapeModel shapeModel);
    public abstract void remove(ShapeModel shapeModel);
    public abstract void clear();
    public abstract Collection<ShapeModel> getChildren();
    public abstract ShapeModel getChild(String id);
}

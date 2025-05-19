package CanvasApp.Model;

import Command.Command;
import Observer.Observable;

import java.util.Collection;

public abstract class ShapeModel extends Observable{
    public abstract String getId();
    public abstract int getX();
    public abstract int getY();
    public abstract int getW();
    public abstract int getH();
    public abstract int getZ();
    public abstract void move(int dx,int dy);
    public abstract void resize(int dw, int dh);
    public abstract void realign(int z);
    public abstract void add(ShapeModel shapeModel);
    public abstract void remove(ShapeModel shapeModel);
    public abstract void clear();
    public abstract Collection<ShapeModel> getChildren();
    public abstract void handleCmd(Command cmd);
    public abstract boolean contains(String id);
}

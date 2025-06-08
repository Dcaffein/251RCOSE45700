package CanvasApp.Model.Decorator;

import CanvasApp.Model.Event.ShapeMoved;
import CanvasApp.Model.Event.ShapeResized;
import CanvasApp.Model.Event.ShapeRealigned;

import CanvasApp.Model.ShapeModel;

import java.util.Collection;

public abstract class ShapeDecorator extends ShapeModel {
    private final ShapeModel decorated;

    public ShapeDecorator(ShapeModel decorated) {
        this.decorated = decorated;
    }

    public ShapeModel getDecorated(){
        return decorated;
    }

    @Override
    public String getId() {
        return decorated.getId();
    }

    @Override
    public int getX() {
        return decorated.getX();
    }

    @Override
    public int getY() {
        return decorated.getY();
    }

    @Override
    public int getW() {
        return decorated.getW();
    }

    @Override
    public int getH() {
        return decorated.getH();
    }

    @Override
    public int getZ() {
        return decorated.getZ();
    }

    @Override
    public void setPositionBy(int dx, int dy) {
        decorated.setPositionBy(dx, dy);
        notify(new ShapeMoved(this));
    }

    @Override
    public void setSizeBy(int dw, int dh) {
        decorated.setSizeBy(dw, dh);
        notify(new ShapeResized(this));
    }

    @Override
    public void setPosition(int newX, int newY) {
        decorated.setPosition(newX, newY);
        notify(new ShapeMoved(this));
    }

    @Override
    public void setSize(int newW, int newH) {
        decorated.setSize(newW, newH);
        notify(new ShapeResized(this));
    }

    @Override
    public void realign(int newZ) {
        decorated.realign(newZ);
        notify(new ShapeRealigned(this));
    }

    @Override
    public void add(ShapeModel shapeModel) {
        decorated.add(shapeModel);
    }

    @Override
    public void remove(ShapeModel shapeModel) {
        decorated.remove(shapeModel);
    }

    @Override
    public void clear() {
        decorated.clear();
    }

    @Override
    public Collection<ShapeModel> getChildren() {
        return decorated.getChildren();
    }


    @Override
    public ShapeModel getChild(String id) {
        return decorated.getChild(id);
    }
}

package CanvasApp.Model.Decorator;

import CanvasApp.Model.Event.ShapeModelMoved;
import CanvasApp.Model.Event.ShapeModelRealigned;
import CanvasApp.Model.Event.ShapeModelResized;
import CanvasApp.Model.ShapeModel;
import Command.Command;

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
    public void move(int newX, int newY) {
        decorated.move(newX, newY);
        notify(new ShapeModelMoved(this));
    }

    @Override
    public void resize(int newW, int newH) {
        decorated.resize(newW, newH);
        notify(new ShapeModelResized(this));
    }

    @Override
    public void realign(int newZ) {
        decorated.realign(newZ);
        notify(new ShapeModelRealigned(this));
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
    public void handleCmd(Command cmd) {
        decorated.handleCmd(cmd);
    }

    @Override
    public boolean contains(String id) {
        return decorated.contains(id);
    }
}

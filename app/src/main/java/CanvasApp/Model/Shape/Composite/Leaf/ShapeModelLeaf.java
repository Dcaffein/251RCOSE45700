package CanvasApp.Model.Shape.Composite.Leaf;

import CanvasApp.Model.Shape.Event.ShapeUpdate.ShapeModelRealigned;
import CanvasApp.Model.Shape.ShapeModel;
import CanvasApp.Model.Shape.Event.ShapeUpdate.ShapeModelMoved;
import CanvasApp.Model.Shape.Event.ShapeUpdate.ShapeModelResized;
import Command.Command;
import Observer.Observer;

import java.util.Collection;

public abstract class ShapeModelLeaf extends ShapeModel {
    protected int x, y;
    protected int w, h;
    protected int z;
    protected String id;
    protected int padding = 2;

    public ShapeModelLeaf(String id, int x, int y, int w, int h, int z) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.z = z;
    }

    @Override
    public String getId() {
        return id;
    }
    @Override
    public int getX() {return x;}
    @Override
    public int getY() {
        return y;
    }
    @Override
    public int getW() {
        return w;
    }
    @Override
    public int getH() {
        return h;
    }
    @Override
    public int getZ() {
        return z;
    }

    @Override
    public void move(int newX, int newY) {
        if(newX > 0) this.x = newX;
        if(newY > 0) this.y = newY;
        notify(new ShapeModelMoved(this));
    }

    @Override
    public void resize(int newW, int newH) {
        if(newW > 0) this.w = newW;
        if(newH > 0) this.h = newH;
        notify(new ShapeModelResized(this));
    }

    @Override
    public void realign(int newZ) {
        if(z > 0) this.z = newZ;
        notify(new ShapeModelRealigned(this));
    }

    @Override
    public void add(ShapeModel shape) {
        throw new UnsupportedOperationException("add not supported on leaf");
    }

    @Override
    public void remove(ShapeModel shape) {
        throw new UnsupportedOperationException("remove not supported on leaf");
    }

    @Override
    public Collection<ShapeModel> getChildren(){
        return null;
    }

    @Override
    public void clear() {
        for(Observer o : observers) {
            detach(o);
        }
    }

    @Override
    public void handleCmd(Command cmd){
        cmd.execute();
    }

    @Override
    public boolean contains(String id) {
        return this.id.equals(id);
    }
}

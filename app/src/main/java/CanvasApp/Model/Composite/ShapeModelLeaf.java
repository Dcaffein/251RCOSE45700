package CanvasApp.Model.Composite;

import CanvasApp.Model.Event.ShapeMoved;
import CanvasApp.Model.Event.ShapeReplaced;
import CanvasApp.Model.Event.ShapeResized;
import CanvasApp.Model.Event.ShapeRealigned;
import Observer.Observer;

import CanvasApp.Model.ShapeModel;

import java.util.List;

public abstract class ShapeModelLeaf extends ShapeModel {
    protected int x, y;
    protected int w, h;
    protected int z;
    protected String id;

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
    public void moveBy(int dx, int dy) {
        int newX = x + dx;
        int newY = y + dy;
        if(newX > 0) this.x = newX;
        if(newY > 0) this.y = newY;
        notify(new ShapeMoved(this));
    }

    @Override
    public void resizeBy(int dw, int dh) {
        System.out.println("[leaf setSizeBy] dw : " + dw + ", dh :" + dh);
        int newW = w + dw;
        int newH = h + dh;
        if(newW < minimum) newW = minimum;
        if(newH < minimum) newH = minimum;
        this.w = newW;
        this.h = newH;
        notify(new ShapeResized(this));
    }

    @Override
    public void moveTo(int newX, int newY) {
        if(newX > 0) this.x = newX;
        if(newY > 0) this.y = newY;
        notify(new ShapeMoved(this));
    }

    @Override
    public void resizeAs(int newW, int newH) {
        if(newW < minimum) newW = minimum;
        if(newH < minimum) newH = minimum;
        this.w = newW;
        this.h = newH;
        notify(new ShapeResized(this));
    }

    @Override
    public void realign(int newZ) {
        if(newZ > 0) this.z = newZ;
        notify(new ShapeRealigned(this));
    }

    @Override
    public void addChild(ShapeModel shape) {}

    @Override
    public void removeChild(ShapeModel shape) {}

    @Override
    public void replace(ShapeModel oldOne, ShapeModel newOne) {
        notify(new ShapeReplaced(newOne));
    }

    @Override
    public List<ShapeModel> getChildren(){
        return null;
    }

    @Override
    public void clear() {
        for(Observer o : observers) {
            detach(o);
        }
    }

    @Override
    public ShapeModel getChild(String id) {
        return null;
    }
}

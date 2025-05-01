package CanvasApp.Model.Shape;

import Observer.Observable;
import CanvasApp.Model.Shape.Observer.ShapeModelMoved;
import CanvasApp.Model.Shape.Observer.ShapeModelResized;

public abstract class ShapeModel extends Observable {
    protected int x, y;
    protected int w, h;
    protected int z;
    protected String id;
    protected int padding = 2;

    public ShapeModel(String id, int x, int y, int w, int h, int z) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.z = z;
    }

    public String getId() {
        return id;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getW() {
        return w;
    }
    public int getH() {
        return h;
    }
    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
        notify(new ShapeModelMoved(id,x,y));
    }

    public void resize(int dw, int dh) {
        this.w += dw;
        this.h += dh;
        notify(new ShapeModelResized(id,w,h));
    }
}

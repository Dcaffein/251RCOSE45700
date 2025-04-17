package Canvas.Domain.ShapeObject;

import Canvas.Domain.Observer.ShapeObjectEvent;
import Canvas.Domain.Observer.ShapeObjectObservable;

public class ShapeObject extends ShapeObjectObservable {
    protected int x, y;
    protected int w, h;
    protected int z;
    protected String id;
    protected int padding = 2;

    public ShapeObject(String id, int x, int y, int w, int h, int z) {
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

    protected void setX(int x) {
        this.x = x;
    }
    protected void setY(int y) {
        this.y = y;
    }
    protected void setW(int w) {
        this.w = w;
    }
    protected void setH(int height) {
        this.h = height;
    }
    protected void setZ(int z) {
        this.z = z;
    }

    public void move(int dx, int dy) {
        setX(x + dx);
        setY(y + dy);
        notifyObservers(new ShapeObjectEvent(getId()));
    }
}

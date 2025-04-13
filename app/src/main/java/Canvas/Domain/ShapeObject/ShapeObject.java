package Canvas.Domain.ShapeObject;

import Canvas.Domain.Observer.ShapeObjectObservable;

import java.awt.*;

public abstract class ShapeObject extends ShapeObjectObservable {
    protected int x, y;
    protected int width, height;
    protected int z;
    protected String id;
    protected int padding = 2;

    public ShapeObject(String id, int x, int y, int width, int height, int z) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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
        return width;
    }
    public int getH() {
        return height;
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
        this.width = w;
    }
    protected void setH(int height) {
        this.height = height;
    }
    protected void setZ(int z) {
        this.z = z;
    }

    public abstract void draw(Graphics g);
    public abstract void move(int dx, int dy);
}

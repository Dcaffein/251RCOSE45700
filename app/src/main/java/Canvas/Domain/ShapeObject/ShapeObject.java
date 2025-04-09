package Canvas.Domain.ShapeObject;

import Canvas.Domain.Observer.Observable;
import java.awt.Graphics;

public abstract class ShapeObject extends Observable {
    protected int x, y;
    protected int width, height;
    protected int z;
    protected String id;

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
    public int getZ() {
        return z;
    }

    public abstract void draw(Graphics g);
}

package Canvas.Domain.ShapeObject;

import java.awt.Graphics;
import Canvas.Domain.Command.ShapeCommand.RenderShape.*;

public class Rectangle extends ShapeObject {
    public Rectangle(String id, int x, int y, int width, int height, int z) {
        super(id, x, y, width, height, z);
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect(padding, padding, width-2*padding, height-2*padding);
    }

    @Override
    public void move(int dx, int dy) {
        setX(getX() + dx);
        setY(getY() + dy);
        notifyObservers(new Moved(getId(),getX(),getY(),getW(),getH()));
    }
}

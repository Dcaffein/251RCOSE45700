package Canvas.Domain.ShapeObject;

import java.awt.*;

public class Rectangle extends ShapeObject {
    public Rectangle(String id, int x, int y, int width, int height, int z) {
        super(id, x, y, width, height, z);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        //hardCode
        g.drawRect(padding, padding, width-2*padding, height-2*padding);
    }
}

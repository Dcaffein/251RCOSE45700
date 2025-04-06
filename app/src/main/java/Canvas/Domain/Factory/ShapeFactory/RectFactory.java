package Canvas.Domain.Factory.ShapeFactory;

import Canvas.Domain.ShapeObject.Rectangle;
import Canvas.Domain.ShapeObject.ShapeObject;

public class RectFactory implements ShapeFactory {
    private static final RectFactory instance = new RectFactory();

    private RectFactory() {}

    public static RectFactory getInstance() {
        return instance;
    }

    @Override
    public ShapeObject create(String id, int x, int y, int width, int height, int z) {
        return new Rectangle(id, x, y, width, height, z);
    }
}
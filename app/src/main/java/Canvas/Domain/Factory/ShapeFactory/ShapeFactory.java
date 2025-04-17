package Canvas.Domain.Factory.ShapeFactory;

import Canvas.Domain.ShapeObject.ShapeObject;
import Canvas.ViewModel.RectangleProp;
import Canvas.ViewModel.ShapeProp;

import java.util.UUID;

public class ShapeFactory {
    private static final ShapeFactory instance = new ShapeFactory();

    private ShapeFactory() {}

    public static ShapeFactory getInstance() {
        return instance;
    }

    public ShapeObject createShapeObject(int x, int y, int w, int h, int z) {
        String id = UUID.randomUUID().toString();
        return new ShapeObject(id, x, y, w, h, z);
    }

    public ShapeProp createShapeViewProps(ShapeObject shapeObject) {
        return new RectangleProp(shapeObject);
    }
}
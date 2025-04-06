package Canvas.Domain.Factory.ShapeFactory;

import Canvas.Domain.ShapeObject.ShapeObject;

public interface ShapeFactory {
    ShapeObject create(String id, int x, int y, int width, int height, int z);
}


package CanvasApp.Factory.Shape;

import CanvasApp.Model.ShapeModel;

import java.util.UUID;

public abstract class ShapeFactory {
    public ShapeModel createShapeModel(int x, int y, int w, int h, int z) {
        String id = UUID.randomUUID().toString();
        return createShapeModel(id, x, y, w, h, z);
    }

    public abstract ShapeModel createShapeModel(String id, int x, int y, int w, int h, int z);
}

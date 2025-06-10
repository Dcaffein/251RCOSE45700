package CanvasApp.Factory.Shape;

import CanvasApp.Model.Composite.ConcreteLeaf.RectModel;
import CanvasApp.Model.ShapeModel;

public class RectFactory extends ShapeFactory {
    private static final RectFactory instance = new RectFactory();
    private RectFactory() {}
    public static RectFactory getInstance() {
        return instance;
    }
    @Override
    public ShapeModel createShapeModel(String id, int x, int y, int w, int h, int z) {
        return new RectModel(id, x, y, w, h, z);
    }
}

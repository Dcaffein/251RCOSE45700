package CanvasApp.Factory.ShapeFactory;

import CanvasApp.Model.Composite.ConcreteLeaf.LineSlashModel;
import CanvasApp.Model.ShapeModel;

public class LineSlashFactory extends ShapeFactory {
    private static final LineSlashFactory instance = new LineSlashFactory();

    private LineSlashFactory() {
    }

    public static LineSlashFactory getInstance() {
        return instance;
    }

    @Override
    public ShapeModel createShapeModel(String id, int x, int y, int w, int h, int z) {
        return new LineSlashModel(id, x, y, w, h, z);
    }
}

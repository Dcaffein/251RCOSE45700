package CanvasApp.Factory.Shape;

import CanvasApp.Model.Composite.ConcreteLeaf.LineBackSlashModel;
import CanvasApp.Model.ShapeModel;

public class LineBackSlashFactory extends ShapeFactory {
    private static final LineBackSlashFactory instance = new LineBackSlashFactory();

    private LineBackSlashFactory() {
    }

    public static LineBackSlashFactory getInstance() {
        return instance;
    }

    @Override
    public ShapeModel createShapeModel(String id, int x, int y, int w, int h, int z) {
        return new LineBackSlashModel(id, x, y, w, h, z);
    }
}

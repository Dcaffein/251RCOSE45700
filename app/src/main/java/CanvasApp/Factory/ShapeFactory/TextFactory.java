package CanvasApp.Factory.ShapeFactory;

import CanvasApp.Model.Composite.ConcreteLeaf.TextModel;
import CanvasApp.Model.ShapeModel;

public class TextFactory extends ShapeFactory{
    private static final TextFactory instance = new TextFactory();
    private TextFactory() {}

    public static TextFactory getInstance() {
        return instance;
    }


    @Override
    public ShapeModel createShapeModel(String id, int x, int y, int w, int h, int z) {
        return new TextModel(id, x, y, w, h, z, "text");
    }

    public ShapeModel createShapeModel(String id,int x,int y,int w,int h, int z, String text) {
        return new TextModel(id,x, y, w, h, z, text);
    }
}

package CanvasApp.Factory.ShapeFactory;

import CanvasApp.Model.Decorator.TextInShape;
import CanvasApp.Model.ShapeModel;

public class DecoratorTextFactory extends ShapeFactory{
    private static final DecoratorTextFactory instance = new DecoratorTextFactory();
    private DecoratorTextFactory() {}

    public static DecoratorTextFactory getInstance() {
        return instance;
    }

    @Override
    public ShapeModel createShapeModel(String id, int x, int y, int w, int h, int z) {
        return null;
    }

    public TextInShape createShapeDecorator(ShapeModel decorated,String text) {
        return new TextInShape(decorated, text);
    }
}

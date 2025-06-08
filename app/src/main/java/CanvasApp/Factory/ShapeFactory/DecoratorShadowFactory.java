package CanvasApp.Factory.ShapeFactory;

import CanvasApp.Model.Decorator.Shadow;
import CanvasApp.Model.ShapeModel;

import java.awt.*;

public class DecoratorShadowFactory extends ShapeFactory{
    private static final DecoratorShadowFactory instance = new DecoratorShadowFactory();
    private DecoratorShadowFactory() {}

    public static DecoratorShadowFactory getInstance() {
        return instance;
    }

    public Shadow createShapeDecorator(ShapeModel decorated, Color color, int border) {
        return new Shadow(decorated,color,border);
    }

    @Override
    public ShapeModel createShapeModel(String id, int x, int y, int w, int h, int z) {
        return null;
    }
}

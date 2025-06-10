package CanvasApp.Factory.Shape.Decorator;

import CanvasApp.Model.Decorator.Shadow;
import CanvasApp.Model.ShapeModel;

public class ShadowFactory {
    private static final ShadowFactory instance = new ShadowFactory();
    private ShadowFactory() {}

    public static ShadowFactory getInstance() {
        return instance;
    }

    public Shadow createDecorator(ShapeModel decorated, int color, int border) {
        return new Shadow(decorated,color,border);
    }

    public Shadow createDecorator(ShapeModel decorated) {
        return new Shadow(decorated,0x000000,5);
    }
}

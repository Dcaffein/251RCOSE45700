package CanvasApp.Factory.Shape.Decorator;

import CanvasApp.Model.Decorator.InnerText;
import CanvasApp.Model.ShapeModel;

public class InnerTextFactory {
    private static final InnerTextFactory instance = new InnerTextFactory();
    private InnerTextFactory() {}

    public static InnerTextFactory getInstance() {
        return instance;
    }

    public InnerText createDecorator(ShapeModel decorated, String text) {
        return new InnerText(decorated, text);
    }

    public InnerText createDecorator(ShapeModel decorated) {
        return new InnerText(decorated, "text");
    }
}

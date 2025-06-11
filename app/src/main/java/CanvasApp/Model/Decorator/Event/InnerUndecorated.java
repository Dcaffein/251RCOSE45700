package CanvasApp.Model.Decorator.Event;

import CanvasApp.Model.Decorator.ShapeDecorator;
import Observer.Event;

public class InnerUndecorated extends Event<ShapeDecorator> {
    public InnerUndecorated(ShapeDecorator source) {
        super(source);
    }
}

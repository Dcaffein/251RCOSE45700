package CanvasApp.Model.Decorator.Event;

import CanvasApp.Model.Decorator.ShapeDecorator;
import Observer.Event;

public class DecoratorStateChanged extends Event<ShapeDecorator> {
    public DecoratorStateChanged(ShapeDecorator source) {
        super(source);
    }
}

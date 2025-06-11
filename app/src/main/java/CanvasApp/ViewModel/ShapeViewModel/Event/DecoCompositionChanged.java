package CanvasApp.ViewModel.ShapeViewModel.Event;

import CanvasApp.Model.Decorator.ShapeDecorator;
import Observer.Event;

public class DecoCompositionChanged extends Event<ShapeDecorator> {
    public DecoCompositionChanged(ShapeDecorator source) {
        super(source);
    }
}

package CanvasApp.Model.Event;

import CanvasApp.Model.ShapeModel;
import Observer.Event;

public abstract class ShapeEvent extends Event<ShapeModel> {
    public ShapeEvent(ShapeModel source) {
        super(source);
    }
}

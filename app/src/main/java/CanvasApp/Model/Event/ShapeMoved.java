package CanvasApp.Model.Event;

import CanvasApp.Model.ShapeModel;
import Observer.Event;

public class ShapeMoved extends Event<ShapeModel> {
    public ShapeMoved(ShapeModel source) {
        super(source);
    }
}
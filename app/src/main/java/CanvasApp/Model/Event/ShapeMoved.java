package CanvasApp.Model.Event;

import CanvasApp.Model.ShapeModel;

public class ShapeMoved extends ShapeEvent {
    public ShapeMoved(ShapeModel source) {
        super(source);
    }
}
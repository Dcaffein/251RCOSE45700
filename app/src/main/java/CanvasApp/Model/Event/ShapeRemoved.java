package CanvasApp.Model.Event;

import CanvasApp.Model.ShapeModel;

public class ShapeRemoved extends ShapeEvent {
    public ShapeRemoved(ShapeModel source) {
        super(source);
    }
}

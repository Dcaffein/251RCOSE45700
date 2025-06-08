package CanvasApp.Model.Event;

import CanvasApp.Model.ShapeModel;

public class ShapeResized extends ShapeEvent {
    public ShapeResized(ShapeModel source) {
        super(source);
    }
}

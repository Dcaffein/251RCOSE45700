package CanvasApp.Model.Event;

import CanvasApp.Model.ShapeModel;

public class ShapeAdded extends ShapeEvent {
    public ShapeAdded(ShapeModel source) {
        super(source);
    }
}

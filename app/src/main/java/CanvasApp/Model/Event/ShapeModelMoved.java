package CanvasApp.Model.Event;

import CanvasApp.Model.ShapeModel;

public class ShapeModelMoved extends ShapeEvent {
    public ShapeModelMoved(ShapeModel source) {
        super(source);
    }
}
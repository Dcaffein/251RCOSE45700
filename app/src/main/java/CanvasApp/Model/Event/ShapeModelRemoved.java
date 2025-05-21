package CanvasApp.Model.Event;

import CanvasApp.Model.ShapeModel;

public class ShapeModelRemoved extends ShapeEvent {
    public ShapeModelRemoved(ShapeModel source) {
        super(source);
    }
}

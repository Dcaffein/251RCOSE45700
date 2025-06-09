package CanvasApp.Model.Event;

import CanvasApp.Model.ShapeModel;
import Observer.Event;

public class ShapeRealigned extends Event<ShapeModel> {
    public ShapeRealigned(ShapeModel source) {
        super(source);
    }
}
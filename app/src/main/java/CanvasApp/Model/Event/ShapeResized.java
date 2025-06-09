package CanvasApp.Model.Event;

import CanvasApp.Model.ShapeModel;
import Observer.Event;

public class ShapeResized extends Event<ShapeModel> {
    public ShapeResized(ShapeModel source) {
        super(source);
    }
}

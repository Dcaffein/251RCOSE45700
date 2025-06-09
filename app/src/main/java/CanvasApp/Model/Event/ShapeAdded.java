package CanvasApp.Model.Event;

import CanvasApp.Model.ShapeModel;
import Observer.Event;

public class ShapeAdded extends Event<ShapeModel> {
    public ShapeAdded(ShapeModel source) {
        super(source);
    }
}

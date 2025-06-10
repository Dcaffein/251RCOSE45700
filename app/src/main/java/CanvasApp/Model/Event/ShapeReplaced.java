package CanvasApp.Model.Event;

import CanvasApp.Model.ShapeModel;
import Observer.Event;

public class ShapeReplaced extends Event<ShapeModel> {
    public ShapeReplaced(ShapeModel source) {
        super(source);
    }
}

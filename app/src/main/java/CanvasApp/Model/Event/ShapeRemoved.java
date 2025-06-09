package CanvasApp.Model.Event;

import CanvasApp.Model.ShapeModel;
import Observer.Event;

public class ShapeRemoved extends Event<String> {
    public ShapeRemoved(String source) {
        super(source);
    }
}

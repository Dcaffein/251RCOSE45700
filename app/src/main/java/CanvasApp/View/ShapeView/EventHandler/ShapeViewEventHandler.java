package CanvasApp.View.ShapeView.EventHandler;

import CanvasApp.View.ShapeView.ShapeView;
import Observer.Event;

public interface ShapeViewEventHandler {
    void handle(ShapeView shapeView, Event<?> event);
}

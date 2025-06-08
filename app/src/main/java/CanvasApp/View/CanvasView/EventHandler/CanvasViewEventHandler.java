package CanvasApp.View.CanvasView.EventHandler;

import CanvasApp.View.CanvasView.CanvasView;
import Observer.Event;

public interface CanvasViewEventHandler {
    void handle(CanvasView canvasView, Event<?> event);
}

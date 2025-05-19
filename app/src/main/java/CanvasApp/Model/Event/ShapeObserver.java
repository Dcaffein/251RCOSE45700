package CanvasApp.Model.Event;

import Observer.Observer;

public interface ShapeObserver extends Observer {
    void onUpdate(ShapeEvent event);
}

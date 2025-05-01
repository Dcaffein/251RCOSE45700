package CanvasApp.Model.Shape.Observer;

import Observer.Observer;

public interface ShapeModelObserver extends Observer {
    void onMoved(ShapeModelMoved event);
    void onResized(ShapeModelResized event);
    void onRealigned(ShapeModelRealigned event);
}

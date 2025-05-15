package CanvasApp.Model.Shape.Event.ShapeUpdate;

import Observer.Observer;

public interface ShapeUpdateObserver extends Observer {
    void onShapeMoved(ShapeModelMoved event);
    void onShapeResized(ShapeModelResized event);
    void onShapeRealigned(ShapeModelRealigned event);
}

package CanvasApp.Model.Canvas.Observer;

import CanvasApp.Model.Shape.Observer.ShapeModelRealigned;
import Observer.Observer;

public interface CanvasModelObserver extends Observer {
    void onShapeAdded(CanvasModelShapeAdded event);
    void onShapeRemoved(CanvasModelShapeRemoved event);
    void onShapeZChanged(ShapeModelRealigned event);
}

package CanvasApp.Model.Shape.Event.ShapeComposition;

import Observer.Observer;

public interface ShapeCompositionObserver extends Observer {
    void onShapeAdded(ShapeModelAdded event);
    void onShapeRemoved(ShapeModelRemoved event);
}

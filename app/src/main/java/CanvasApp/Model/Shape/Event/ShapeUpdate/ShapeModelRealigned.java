package CanvasApp.Model.Shape.Event.ShapeUpdate;

import CanvasApp.Model.Shape.ShapeModel;

public class ShapeModelRealigned extends ShapeUpdate {
    public ShapeModelRealigned(ShapeModel source) {
        super(source);
    }

    @Override
    public void dispatchUpdateEvent(ShapeUpdateObserver observer) {
        observer.onShapeRealigned(this);
    }
}
package CanvasApp.Model.Shape.Event.ShapeUpdate;

import CanvasApp.Model.Shape.ShapeModel;

public class ShapeModelMoved extends ShapeUpdate {
    public ShapeModelMoved(ShapeModel source) {
        super(source);
    }

    @Override
    public void dispatchUpdateEvent(ShapeUpdateObserver observer) {
        observer.onShapeMoved(this);
    }
}

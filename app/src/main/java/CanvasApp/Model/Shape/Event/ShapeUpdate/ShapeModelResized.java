package CanvasApp.Model.Shape.Event.ShapeUpdate;

import CanvasApp.Model.Shape.ShapeModel;

public class ShapeModelResized extends ShapeUpdate {
    public ShapeModelResized(ShapeModel source) {
        super(source);
    }

    @Override
    public void dispatchUpdateEvent(ShapeUpdateObserver observer) {
        observer.onShapeResized(this);
    }
}

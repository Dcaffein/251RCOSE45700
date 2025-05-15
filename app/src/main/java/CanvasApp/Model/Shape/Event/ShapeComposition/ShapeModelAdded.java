package CanvasApp.Model.Shape.Event.ShapeComposition;

import CanvasApp.Model.Shape.ShapeModel;

public class ShapeModelAdded extends ShapeComposition{
    public ShapeModelAdded(ShapeModel source) {
        super(source);
    }

    @Override
    public void dispatchCompositionEvent(ShapeCompositionObserver observer) {
        observer.onShapeAdded(this);
    }
}

package CanvasApp.Model.Shape.Event.ShapeComposition;

import CanvasApp.Factory.ShapeFactory;
import CanvasApp.Model.Shape.ShapeModel;

public class ShapeModelRemoved extends ShapeComposition {
    public ShapeModelRemoved(ShapeModel source) {
        super(source);
    }

    @Override
    public void dispatchCompositionEvent(ShapeCompositionObserver observer) {
        observer.onShapeRemoved(this);
    }

}

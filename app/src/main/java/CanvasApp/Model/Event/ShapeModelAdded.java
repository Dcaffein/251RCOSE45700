package CanvasApp.Model.Event;

import CanvasApp.Model.ShapeModel;

public class ShapeModelAdded extends ShapeEvent {
    public ShapeModelAdded(ShapeModel source) {
        super(source);
    }

//    @Override
//    public void dispatchCompositionEvent(ShapeCollectionObserver observer) {
//        observer.onShapeAdded(this);
//    }
}

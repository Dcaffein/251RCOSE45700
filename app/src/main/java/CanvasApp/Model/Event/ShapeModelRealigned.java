package CanvasApp.Model.Event;

import CanvasApp.Model.ShapeModel;

public class ShapeModelRealigned extends ShapeEvent {
    public ShapeModelRealigned(ShapeModel source) {
        super(source);
    }

//    @Override
//    public void dispatchUpdateEvent(ShapeObserver observer) {
//        observer.onShapeRealigned(this);
//    }
}
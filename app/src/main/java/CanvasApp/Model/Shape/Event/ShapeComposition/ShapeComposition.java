package CanvasApp.Model.Shape.Event.ShapeComposition;

import CanvasApp.Model.Shape.ShapeModel;
import Observer.Event;
import Observer.Observer;

public abstract class ShapeComposition extends Event<ShapeModel> {
    public ShapeComposition(ShapeModel source) {
        super(source);
    }

    @Override
    public void dispatch(Observer o) {
        if (o instanceof ShapeCompositionObserver observer) {
            dispatchCompositionEvent(observer);
        }
    }

    public abstract void dispatchCompositionEvent(ShapeCompositionObserver observer);
}

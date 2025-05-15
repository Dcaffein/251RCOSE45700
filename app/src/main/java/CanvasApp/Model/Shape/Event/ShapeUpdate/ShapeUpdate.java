package CanvasApp.Model.Shape.Event.ShapeUpdate;

import CanvasApp.Model.Shape.Event.ShapeComposition.ShapeCompositionObserver;
import CanvasApp.Model.Shape.ShapeModel;
import Observer.Event;
import Observer.Observer;

public abstract class ShapeUpdate extends Event<ShapeModel> {
    public ShapeUpdate(ShapeModel source) {
        super(source);
    }

    @Override
    public void dispatch(Observer o) {
        if (o instanceof ShapeUpdateObserver observer) {
            dispatchUpdateEvent(observer);
        }
    }

    public abstract void dispatchUpdateEvent(ShapeUpdateObserver observer);
}

package CanvasApp.Model.Event;

import CanvasApp.Model.ShapeModel;
import Observer.Event;
import Observer.Observer;

public abstract class ShapeEvent extends Event<ShapeModel> {
    public ShapeEvent(ShapeModel source) {
        super(source);
    }

    @Override
    public void dispatch(Observer o) {
        if (o instanceof ShapeObserver observer) {
            observer.onUpdate(this);
        }
    }
}
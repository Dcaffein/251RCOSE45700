package CanvasApp.ViewModel.ShapeData.Observer;

import Observer.Event;
import Observer.Observer;

public abstract class ShapeDataEvent extends Event {
    String id;

    public ShapeDataEvent(String id) {
        this.id = id;
    }

    @Override
    public void dispatch(Observer o) {
        if (o instanceof ShapeDataObserver observer) {
            dispatchShapeDataEvent(observer);
        }
    }
    public abstract void dispatchShapeDataEvent(ShapeDataObserver o);
}

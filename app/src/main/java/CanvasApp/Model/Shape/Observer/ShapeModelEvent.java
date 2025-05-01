package CanvasApp.Model.Shape.Observer;

import Observer.Event;
import Observer.Observer;

public abstract class ShapeModelEvent extends Event {
    public String id;
    public ShapeModelEvent(String id) {
        this.id = id;
    }

    @Override
    public void dispatch(Observer o){
        if (o instanceof ShapeModelObserver observer) {
            dispatchShapeModelEvent(observer);
        }
    }


    public abstract void dispatchShapeModelEvent(ShapeModelObserver o);
}
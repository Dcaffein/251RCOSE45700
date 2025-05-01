package CanvasApp.Model.Canvas.Observer;

import Observer.Event;
import Observer.Observer;

public abstract class CanvasModelEvent extends Event {
    public String id;
    public CanvasModelEvent(String id){
        this.id = id;
    }

    @Override
    public void dispatch(Observer o) {
        if (o instanceof CanvasModelObserver observer) {
            dispatchCanvasModelEvent(observer);
        }
    }
    public abstract void dispatchCanvasModelEvent(CanvasModelObserver o);
}

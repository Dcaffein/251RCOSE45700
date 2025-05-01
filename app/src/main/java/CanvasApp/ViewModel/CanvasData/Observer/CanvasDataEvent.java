package CanvasApp.ViewModel.CanvasData.Observer;

import Observer.Event;
import Observer.Observer;

public abstract class CanvasDataEvent extends Event {
    @Override
    public void dispatch(Observer o) {
        if (o instanceof CanvasDataObserver observer) {
            dispatchCanvasDataEvent(observer);
        }
    }
    public abstract void dispatchCanvasDataEvent(CanvasDataObserver o);
}

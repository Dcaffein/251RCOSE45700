package CanvasApp.ViewModel.Data.CanvasData.Event;

import Observer.*;

public abstract class CanvasDataEvent<T> extends Event<T> {
    public CanvasDataEvent(T source) {
        super(source);
    }

    @Override
    public void dispatch(Observer o) {
        if (o instanceof CanvasDataObserver observer) {
            observer.onUpdate(this);
        }
    }
}

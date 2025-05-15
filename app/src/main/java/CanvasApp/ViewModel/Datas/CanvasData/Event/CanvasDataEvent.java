package CanvasApp.ViewModel.Datas.CanvasData.Event;

import Observer.Event;
import Observer.Observer;

public abstract class CanvasDataEvent<T> extends Event<T> {
    public CanvasDataEvent(T source) {
        super(source);
    }

    @Override
    public void dispatch(Observer o) {
        if (o instanceof CanvasDataObserver observer) {
            dispatchCanvasDataEvent(observer);
        }
    }
    public abstract void dispatchCanvasDataEvent(CanvasDataObserver o);
}

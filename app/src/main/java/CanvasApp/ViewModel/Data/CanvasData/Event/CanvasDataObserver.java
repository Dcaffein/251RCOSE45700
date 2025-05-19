package CanvasApp.ViewModel.Data.CanvasData.Event;

import Observer.Observer;

public interface CanvasDataObserver extends Observer {
    void onUpdate(CanvasDataEvent<?> canvasDataEvent);
}

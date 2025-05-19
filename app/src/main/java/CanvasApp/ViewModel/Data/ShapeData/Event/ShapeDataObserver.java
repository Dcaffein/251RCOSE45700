package CanvasApp.ViewModel.Data.ShapeData.Event;

import Observer.Observer;

public interface ShapeDataObserver extends Observer {
    void onUpdate(ShapeDataEvent shapeDataEvent);
}

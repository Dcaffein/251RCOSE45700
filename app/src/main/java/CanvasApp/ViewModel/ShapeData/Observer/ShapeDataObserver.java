package CanvasApp.ViewModel.ShapeData.Observer;

import Observer.Observer;

public interface ShapeDataObserver extends Observer {
    void onMoved(ShapeDataMoved event);
    void onResized(ShapeDataResized event);
}

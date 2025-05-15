package CanvasApp.ViewModel.Datas.ShapeData.Event;

import Observer.Observer;

public interface ShapeDataObserver extends Observer {
    void onMoved(ShapeDataMoved event);
    void onResized(ShapeDataResized event);
    void onRealigned(ShapeDataRealigned event);
}

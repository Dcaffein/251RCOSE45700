package CanvasApp.ViewModel.CanvasData.Observer;

import Observer.Observer;

public interface CanvasDataObserver extends Observer {
    void onShapeAdded(CanvasDataShapeAdded event);
    void onShapeRemoved(CanvasDataShapeRemoved event);
    void onRealigned(CanvasDataShapeRealigned event);
    void onCanvasDataDraggableSet(CanvasDataDraggableSet event);
}

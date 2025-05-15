package CanvasApp.ViewModel.Datas.CanvasData.Event;

import CanvasApp.ViewModel.Datas.CanvasData.CanvasData;

public class CanvasDataDraggableSet extends CanvasDataEvent<CanvasData> {

    public CanvasDataDraggableSet(CanvasData canvasData) {
        super(canvasData);
    }

    @Override
    public void dispatchCanvasDataEvent(CanvasDataObserver o) {
        System.out.println("[CanvasDataDraggableSet] dispatching to observer");
        o.onCanvasDataDraggableSet(this);
    }

}

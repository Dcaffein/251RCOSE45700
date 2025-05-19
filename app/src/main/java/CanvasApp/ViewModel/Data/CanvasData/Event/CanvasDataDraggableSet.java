package CanvasApp.ViewModel.Data.CanvasData.Event;

import CanvasApp.ViewModel.Data.CanvasData.CanvasData;

public class CanvasDataDraggableSet extends CanvasDataEvent<CanvasData> {

    public CanvasDataDraggableSet(CanvasData canvasData) {
        super(canvasData);
    }
}

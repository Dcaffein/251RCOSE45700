package CanvasApp.View.CanvasView.EventHandler;

import CanvasApp.ViewModel.Data.CanvasData.Event.CanvasDataEvent;
import Observer.EventHandlingStrategy;

public abstract class HandleCanvasView implements EventHandlingStrategy<CanvasDataEvent<?>> {
    CanvasDataEventHandler canvasDataEventHandler;

    public HandleCanvasView(CanvasDataEventHandler canvasDataEventHandler) {
        this.canvasDataEventHandler = canvasDataEventHandler;
    }
}

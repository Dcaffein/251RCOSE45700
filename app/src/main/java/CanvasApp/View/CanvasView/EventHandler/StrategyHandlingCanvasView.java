package CanvasApp.View.CanvasView.EventHandler;

import CanvasApp.ViewModel.Data.CanvasData.Event.CanvasDataEvent;
import Observer.EventHandlingStrategy;

public abstract class StrategyHandlingCanvasView implements EventHandlingStrategy<CanvasDataEvent<?>> {
    CanvasDataEventHandler canvasDataEventHandler;

    public StrategyHandlingCanvasView(CanvasDataEventHandler canvasDataEventHandler) {
        this.canvasDataEventHandler = canvasDataEventHandler;
    }
}

package CanvasApp.ViewModel.EventHandler.CanvasEventHandler;

import CanvasApp.Model.Event.ShapeEvent;
import Observer.EventHandlingStrategy;

public abstract class HandleCanvas implements EventHandlingStrategy<ShapeEvent> {
    protected CanvasHandler context;

    public HandleCanvas(CanvasHandler context) {
        this.context = context;
    }
}

package CanvasApp.ViewModel.EventHandler.CanvasHandler.Strategy;

import CanvasApp.Model.Event.ShapeEvent;
import CanvasApp.ViewModel.EventHandler.CanvasHandler.CanvasHandler;
import Observer.EventHandlingStrategy;

public abstract class StrategyHandlingCanvas implements EventHandlingStrategy<ShapeEvent> {
    protected CanvasHandler context;

    public StrategyHandlingCanvas(CanvasHandler context) {
        this.context = context;
    }
}

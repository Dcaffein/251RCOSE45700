package CanvasApp.ViewModel.EventHandler.SelectedHandler;

import CanvasApp.Model.Event.ShapeEvent;
import Observer.EventHandlingStrategy;

public abstract class StrategyHandlingSelected implements EventHandlingStrategy<ShapeEvent> {
    protected SelectedHandler context;

    public StrategyHandlingSelected(SelectedHandler context) {
        this.context = context;
    }
}

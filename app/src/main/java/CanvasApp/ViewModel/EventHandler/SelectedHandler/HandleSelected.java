package CanvasApp.ViewModel.EventHandler.SelectedHandler;

import CanvasApp.Model.Event.ShapeEvent;
import Observer.EventHandlingStrategy;

public abstract class HandleSelected implements EventHandlingStrategy<ShapeEvent> {
    protected SelectedHandler context;

    public HandleSelected(SelectedHandler context) {
        this.context = context;
    }
}

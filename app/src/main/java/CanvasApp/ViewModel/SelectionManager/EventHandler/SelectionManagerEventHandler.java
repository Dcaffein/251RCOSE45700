package CanvasApp.ViewModel.SelectionManager.EventHandler;

import CanvasApp.ViewModel.SelectionManager.SelectionManager;
import Observer.Event;

public interface SelectionManagerEventHandler {
    void handle(SelectionManager selectionManager, Event<?> event);
}

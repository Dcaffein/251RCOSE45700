package CanvasApp.ViewModel.CanvasViewModel.EventHandler;

import CanvasApp.ViewModel.CanvasViewModel.CanvasViewModel;
import Observer.Event;

public interface CanvasViewModelEventHandler {
    void handle(CanvasViewModel canvasViewModel, Event<?> event);
}

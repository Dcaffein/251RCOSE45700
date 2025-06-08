package CanvasApp.ViewModel.ShapeViewModel.EventHandler;

import CanvasApp.ViewModel.ShapeViewModel.ShapeViewModel;
import Observer.Event;

public interface ShapeViewModelEventHandler {
    void handle(ShapeViewModel shapeViewModel, Event<?> event);
}

package CanvasApp.ViewModel.ShapeViewModel.EventHandler;

import CanvasApp.ViewModel.ShapeViewModel.ShapeViewModel;
import Observer.Event;

public class OnShapeMoved implements ShapeViewModelEventHandler {
    @Override
    public void handle(ShapeViewModel shapeViewModel, Event<?> event) {
        shapeViewModel.notify(event);
    }
}

package CanvasApp.ViewModel.SelectionManager.EventHandler;

import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.SelectionManager.SelectionManager;
import Observer.Event;

public class OnShapeDeleted implements SelectionManagerEventHandler{
    @Override
    public void handle(SelectionManager selectionManager, Event<?> event) {
        if(event.source instanceof ShapeModel shape) {
            selectionManager.remove(shape.getId());
        }
    }
}

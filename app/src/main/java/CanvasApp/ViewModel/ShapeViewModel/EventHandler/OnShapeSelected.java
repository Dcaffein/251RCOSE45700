package CanvasApp.ViewModel.ShapeViewModel.EventHandler;

import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.ShapeViewModel.ShapeViewModel;
import Observer.Event;

public class OnShapeSelected implements ShapeViewModelEventHandler {
    @Override
    public void handle(ShapeViewModel shapeViewModel, Event<?> event) {
        ShapeModel shape = ((ShapeModel)event.source);
        if (shape == shapeViewModel.shape){
            shapeViewModel.setSelected(true);
        }
    }
}

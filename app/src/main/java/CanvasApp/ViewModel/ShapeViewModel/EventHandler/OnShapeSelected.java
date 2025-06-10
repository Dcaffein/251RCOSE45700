package CanvasApp.ViewModel.ShapeViewModel.EventHandler;

import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.SelectionManager.Event.ShapeSelected;
import CanvasApp.ViewModel.ShapeViewModel.ShapeViewModel;
import Observer.Event;

public class OnShapeSelected implements ShapeViewModelEventHandler {
    @Override
    public void handle(ShapeViewModel shapeViewModel, Event<?> event) {
        if(event instanceof ShapeSelected shapeSelected){
            ShapeModel shape = shapeSelected.source;
            if (shape == shapeViewModel.getShape()){
                shapeViewModel.setSelected(true);
            }
        }
    }
}

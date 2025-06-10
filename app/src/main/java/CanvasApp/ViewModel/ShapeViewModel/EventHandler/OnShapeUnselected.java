package CanvasApp.ViewModel.ShapeViewModel.EventHandler;

import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.SelectionManager.Event.ShapeUnselected;
import CanvasApp.ViewModel.ShapeViewModel.ShapeViewModel;
import Observer.Event;

import java.util.List;

public class OnShapeUnselected implements ShapeViewModelEventHandler {
    @Override
    public void handle(ShapeViewModel shapeViewModel, Event<?> event) {
        if(event instanceof ShapeUnselected shapeUnselected){
            List<ShapeModel> unselected = shapeUnselected.source;
            if(unselected.contains(shapeViewModel.getShape())){
                shapeViewModel.setSelected(false);
            }
        }
    }
}

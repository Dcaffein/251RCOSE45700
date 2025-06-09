package CanvasApp.ViewModel.PropertyViewModel.EventHandlers;

import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.PropertyViewModel.PropertyViewModel;
import CanvasApp.ViewModel.SelectionManager.Event.ShapeUnselected;
import Observer.Event;

import java.util.List;

public class OnShapeUnselected implements PropertyViewModelEventHandler {
    @Override
    public void handle(PropertyViewModel viewModel, Event<?> event) {
        if(event instanceof ShapeUnselected shapeUnselected) {
            List<ShapeModel> unselected = shapeUnselected.source;
            for(ShapeModel shape : unselected) {
                shape.detach(viewModel);
            }
        }
        viewModel.recalculate();
    }
}

package CanvasApp.ViewModel.PropertyViewModel.EventHandlers;

import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.PropertyViewModel.PropertyViewModel;
import CanvasApp.ViewModel.SelectionManager.Event.ShapeSelected;
import Observer.Event;

public class OnShapeSelected implements PropertyViewModelEventHandler {
    @Override
    public void handle(PropertyViewModel viewModel, Event<?> event) {
        if(event instanceof ShapeSelected shapeSelected) {
            ShapeModel selected = shapeSelected.source;
            selected.attach(viewModel);
        }
        viewModel.recalculate();
    }
}

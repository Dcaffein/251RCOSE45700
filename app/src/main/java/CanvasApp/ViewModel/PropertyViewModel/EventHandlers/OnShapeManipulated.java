package CanvasApp.ViewModel.PropertyViewModel.EventHandlers;

import CanvasApp.ViewModel.PropertyViewModel.PropertyViewModel;
import Observer.Event;

public class OnShapeManipulated implements PropertyViewModelEventHandler {
    @Override
    public void handle(PropertyViewModel viewModel, Event<?> event) {
        viewModel.recalculate();
    }
}

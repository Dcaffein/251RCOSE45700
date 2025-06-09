package CanvasApp.ViewModel.PropertyViewModel.EventHandlers;

import CanvasApp.ViewModel.PropertyViewModel.PropertyViewModel;
import Observer.Event;

public interface PropertyViewModelEventHandler {
    void handle(PropertyViewModel viewModel, Event<?> event);
}

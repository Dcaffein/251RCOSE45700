package CanvasApp.ViewModel.PropertyViewModel.Event;

import CanvasApp.ViewModel.PropertyViewModel.PropertyViewModel;
import Observer.Event;

public class PropertyViewModelUpdated extends Event<PropertyViewModel> {
    public PropertyViewModelUpdated(PropertyViewModel source) {
        super(source);
    }
}

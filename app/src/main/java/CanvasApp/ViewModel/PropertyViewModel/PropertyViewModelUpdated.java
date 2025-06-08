package CanvasApp.ViewModel.PropertyViewModel;

import Observer.Event;

public class PropertyViewModelUpdated extends Event<PropertyViewModel> {
    public PropertyViewModelUpdated(PropertyViewModel source) {
        super(source);
    }
}

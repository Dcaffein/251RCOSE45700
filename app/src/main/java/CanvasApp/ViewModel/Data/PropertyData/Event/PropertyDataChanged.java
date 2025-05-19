package CanvasApp.ViewModel.Data.PropertyData.Event;

import CanvasApp.ViewModel.Data.PropertyData.PropertyData;
import Observer.Event;
import Observer.Observer;

public class PropertyDataChanged extends Event<PropertyData> {
    public PropertyDataChanged(PropertyData source) {
        super(source);
    }

    @Override
    public void dispatch(Observer o) {
        if(o instanceof PropertyDataObserver observer) {
            observer.onUpdate(this);
        }
    }
}

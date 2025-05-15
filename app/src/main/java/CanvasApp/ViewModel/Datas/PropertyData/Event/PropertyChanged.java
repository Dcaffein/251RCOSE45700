package CanvasApp.ViewModel.Datas.PropertyData.Event;

import CanvasApp.ViewModel.Datas.PropertyData.PropertyData;
import Observer.Event;
import Observer.Observer;

public class PropertyChanged extends Event<PropertyData> {
    public PropertyChanged(PropertyData source) {
        super(source);
    }

    @Override
    public void dispatch(Observer o) {
        if(o instanceof PropertyObserver observer) {
            observer.onPropertyChanged(this);
        }
    }
}

package CanvasApp.ViewModel.Datas.PropertyData.Event;

import CanvasApp.ViewModel.Datas.PropertyData.PropertyData;
import Observer.Observer;

public interface PropertyObserver extends Observer {
    void onPropertyChanged(PropertyChanged event);
}

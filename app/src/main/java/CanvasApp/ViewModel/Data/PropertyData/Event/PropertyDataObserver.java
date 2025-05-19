package CanvasApp.ViewModel.Data.PropertyData.Event;

import Observer.Observer;

public interface PropertyDataObserver extends Observer {
    void onUpdate(PropertyDataChanged event);
}

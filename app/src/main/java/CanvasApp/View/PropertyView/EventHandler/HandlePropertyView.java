package CanvasApp.View.PropertyView.EventHandler;

import CanvasApp.ViewModel.Data.PropertyData.Event.PropertyDataChanged;
import Observer.EventHandlingStrategy;

public abstract class HandlePropertyView implements EventHandlingStrategy<PropertyDataChanged> {
    public PropertyDataEventHandler propertyDataEventHandler;

    public HandlePropertyView(PropertyDataEventHandler propertyDataEventHandler) {
        this.propertyDataEventHandler = propertyDataEventHandler;
    }

}

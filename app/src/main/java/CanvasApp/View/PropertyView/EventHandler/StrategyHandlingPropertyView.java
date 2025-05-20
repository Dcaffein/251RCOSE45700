package CanvasApp.View.PropertyView.EventHandler;

import CanvasApp.ViewModel.Data.PropertyData.Event.PropertyDataChanged;
import Observer.EventHandlingStrategy;

public abstract class StrategyHandlingPropertyView implements EventHandlingStrategy<PropertyDataChanged> {
    public PropertyDataEventHandler propertyDataEventHandler;

    public StrategyHandlingPropertyView(PropertyDataEventHandler propertyDataEventHandler) {
        this.propertyDataEventHandler = propertyDataEventHandler;
    }

}

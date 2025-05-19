package CanvasApp.View.PropertyView.EventHandler;

import CanvasApp.ViewModel.Data.PropertyData.Event.PropertyDataChanged;

public class HandleSelectedUpdated extends HandlePropertyView{
    public HandleSelectedUpdated(PropertyDataEventHandler propertyDataEventHandler) {
        super(propertyDataEventHandler);
    }

    @Override
    public void handle(PropertyDataChanged event) {
        propertyDataEventHandler.propertyViewContext.updateFields(event.source);
    }
}

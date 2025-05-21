package CanvasApp.View.PropertyView.EventHandler;

import CanvasApp.ViewModel.Data.PropertyData.Event.PropertyDataChanged;

public class HandleSelectedUpdated extends StrategyHandlingPropertyView {
    public HandleSelectedUpdated(PropertyDataEventHandler propertyDataEventHandler) {
        super(propertyDataEventHandler);
    }

    @Override
    public void handle(PropertyDataChanged event) {
//        System.out.println("[PropertyDataChanged] : " + event.source.getX() + "," + event.source.getY());
        propertyDataEventHandler.propertyViewContext.updateFields(event.source);
    }
}

package CanvasApp.ViewModel.EventHandler.SelectedHandler;

import CanvasApp.Model.Event.ShapeEvent;

public class StrategyOnSelectedUpdated extends StrategyHandlingSelected {
    public StrategyOnSelectedUpdated(SelectedHandler context) {
        super(context);
    }

    @Override
    public void handle(ShapeEvent event) {
//        System.out.println("[Handle selected] event.x : " + event.source.getX() + ", event.y :" + event.source.getY());
        context.propertyData.recalculate();
    }
}

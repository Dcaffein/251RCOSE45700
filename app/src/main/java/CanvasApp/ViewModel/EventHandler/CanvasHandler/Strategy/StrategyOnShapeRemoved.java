package CanvasApp.ViewModel.EventHandler.CanvasHandler.Strategy;

import CanvasApp.Model.Event.ShapeEvent;
import CanvasApp.Model.Event.ShapeModelRemoved;
import CanvasApp.ViewModel.EventHandler.CanvasHandler.CanvasHandler;

public class StrategyOnShapeRemoved extends StrategyHandlingCanvas {
    public StrategyOnShapeRemoved(CanvasHandler context) {
        super(context);
    }

    @Override
    public void handle(ShapeEvent event) {
        if(event instanceof ShapeModelRemoved) {
            event.source.detach(context);
            context.canvasData.removeShape(event.source.getId());
        }
    }
}

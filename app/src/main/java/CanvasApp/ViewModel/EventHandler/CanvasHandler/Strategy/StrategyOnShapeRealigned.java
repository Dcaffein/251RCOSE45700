package CanvasApp.ViewModel.EventHandler.CanvasHandler.Strategy;

import CanvasApp.Model.Event.ShapeEvent;
import CanvasApp.Model.Event.ShapeModelRealigned;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;
import CanvasApp.ViewModel.EventHandler.CanvasHandler.CanvasHandler;

public class StrategyOnShapeRealigned extends StrategyHandlingCanvas {
    public StrategyOnShapeRealigned(CanvasHandler context) {
        super(context);
    }

    @Override
    public void handle(ShapeEvent event) {
        if(event instanceof ShapeModelRealigned) {
            ShapeData shapeData = context.canvasData.getShapeData(event.source.getId());
            shapeData.updateZ(event.source.getZ());
            context.canvasData.realign(shapeData);
        }
    }
}

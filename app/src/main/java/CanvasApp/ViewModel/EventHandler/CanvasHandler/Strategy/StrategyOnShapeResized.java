package CanvasApp.ViewModel.EventHandler.CanvasHandler.Strategy;

import CanvasApp.Model.Event.ShapeEvent;
import CanvasApp.Model.Event.ShapeModelResized;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;
import CanvasApp.ViewModel.EventHandler.CanvasHandler.CanvasHandler;

public class StrategyOnShapeResized extends StrategyHandlingCanvas {
    public StrategyOnShapeResized(CanvasHandler context) {
        super(context);
    }

    @Override
    public void handle(ShapeEvent event) {
        if(event instanceof ShapeModelResized) {
            System.out.println("[ShapeResized] event.w : " + event.source.getW() + ", event.h :" + event.source.getH());
            ShapeData shapeData = context.canvasData.getShapeData(event.source.getId());
            shapeData.resize(event.source.getW(), event.source.getH());
        }
    }
}

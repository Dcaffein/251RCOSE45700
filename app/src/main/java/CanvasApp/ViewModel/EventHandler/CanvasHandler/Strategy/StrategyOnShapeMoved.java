package CanvasApp.ViewModel.EventHandler.CanvasHandler.Strategy;

import CanvasApp.Model.Event.ShapeEvent;
import CanvasApp.Model.Event.ShapeModelMoved;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;
import CanvasApp.ViewModel.EventHandler.CanvasHandler.CanvasHandler;

public class StrategyOnShapeMoved extends StrategyHandlingCanvas {
    public StrategyOnShapeMoved(CanvasHandler context) {
        super(context);
    }

    @Override
    public void handle(ShapeEvent event) {
        if(event instanceof ShapeModelMoved) {
//            System.out.println("[ShapeMoved] event.x : " + event.source.getX() + ", event.y :" + event.source.getY());
            ShapeData shapeData = context.canvasData.getShapeData(event.source.getId());
            shapeData.move(event.source.getX(), event.source.getY());
        }
    }
}

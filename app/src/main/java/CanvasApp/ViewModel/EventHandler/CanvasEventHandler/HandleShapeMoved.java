package CanvasApp.ViewModel.EventHandler.CanvasEventHandler;

import CanvasApp.Model.Event.ShapeEvent;
import CanvasApp.Model.Event.ShapeModelMoved;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

public class HandleShapeMoved extends HandleCanvas {
    public HandleShapeMoved(CanvasHandler context) {
        super(context);
    }

    @Override
    public void handle(ShapeEvent event) {
        if(event instanceof ShapeModelMoved) {
            ShapeData shapeData = context.canvasData.getShapeData(event.source.getId());
            shapeData.updatePosition(event.source.getX(), event.source.getY());
        }
    }
}

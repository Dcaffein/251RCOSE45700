package CanvasApp.ViewModel.EventHandler.CanvasEventHandler;

import CanvasApp.Model.Event.ShapeEvent;
import CanvasApp.Model.Event.ShapeModelRealigned;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

public class HandleShapeRealigned extends HandleCanvas{
    public HandleShapeRealigned(CanvasHandler context) {
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

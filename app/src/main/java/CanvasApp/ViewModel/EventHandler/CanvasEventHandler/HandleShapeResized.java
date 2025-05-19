package CanvasApp.ViewModel.EventHandler.CanvasEventHandler;

import CanvasApp.Model.Event.ShapeEvent;
import CanvasApp.Model.Event.ShapeModelResized;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

public class HandleShapeResized extends HandleCanvas{
    public HandleShapeResized(CanvasHandler context) {
        super(context);
    }

    @Override
    public void handle(ShapeEvent event) {
        if(event instanceof ShapeModelResized) {
            ShapeData shapeData = context.canvasData.getShapeData(event.source.getId());
            shapeData.updateSize(event.source.getW(), event.source.getH());
        }
    }
}

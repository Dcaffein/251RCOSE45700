package CanvasApp.ViewModel.EventHandler.CanvasEventHandler;

import CanvasApp.Model.Event.ShapeEvent;
import CanvasApp.Model.Event.ShapeModelRemoved;

public class HandleShapeRemoved extends HandleCanvas {
    public HandleShapeRemoved(CanvasHandler context) {
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

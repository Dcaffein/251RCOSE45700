package CanvasApp.View.CanvasView.EventHandler;

import CanvasApp.ViewModel.Data.CanvasData.Event.CanvasDataDraggableSet;
import CanvasApp.ViewModel.Data.CanvasData.Event.CanvasDataEvent;

public class HandleCanvasDataDraggableSet extends HandleCanvasView{
    public HandleCanvasDataDraggableSet(CanvasDataEventHandler canvasDataEventHandler) {
        super(canvasDataEventHandler);
    }

    @Override
    public void handle(CanvasDataEvent<?> event) {
        if(event instanceof CanvasDataDraggableSet e){
            canvasDataEventHandler.canvasViewContext.setGlassPaneVisible(e.source.isDraggable());
        }
    }
}

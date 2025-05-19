package CanvasApp.View.CanvasView.EventHandler;

import CanvasApp.View.CanvasView.CanvasViewContext;
import CanvasApp.View.ShapeView.ShapeView;
import CanvasApp.ViewModel.Data.CanvasData.Event.CanvasDataEvent;
import CanvasApp.ViewModel.Data.CanvasData.Event.CanvasDataShapeAdded;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

public class HandleCanvasDataShapeAdded extends HandleCanvasView{
    public HandleCanvasDataShapeAdded(CanvasDataEventHandler canvasDataEventHandler) {
        super(canvasDataEventHandler);
    }

    @Override
    public void handle(CanvasDataEvent<?> event) {
        if(event instanceof CanvasDataShapeAdded e){
            CanvasViewContext canvasViewContext = canvasDataEventHandler.canvasViewContext;
            ShapeData shapeData = e.source;
            canvasViewContext.createShapeView(shapeData);
        }
    }
}

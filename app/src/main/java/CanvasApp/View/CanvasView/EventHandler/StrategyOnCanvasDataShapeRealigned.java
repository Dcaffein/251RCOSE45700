package CanvasApp.View.CanvasView.EventHandler;

import CanvasApp.View.CanvasView.CanvasViewContext;
import CanvasApp.ViewModel.Data.CanvasData.Event.CanvasDataEvent;
import CanvasApp.ViewModel.Data.CanvasData.Event.CanvasDataShapeRealigned;

import java.awt.*;

public class StrategyOnCanvasDataShapeRealigned extends StrategyHandlingCanvasView {
    public StrategyOnCanvasDataShapeRealigned(CanvasDataEventHandler canvasDataEventHandler) {
        super(canvasDataEventHandler);
    }

    @Override
    public void handle(CanvasDataEvent<?> event) {
        if(event instanceof CanvasDataShapeRealigned e){
            CanvasViewContext canvasViewContext = canvasDataEventHandler.canvasViewContext;
            Component component = canvasViewContext.findComponentById(e.source.getId());
            canvasViewContext.setChildViewLayerOnLayeredPane(component,e.source.getZ());
        }
    }
}

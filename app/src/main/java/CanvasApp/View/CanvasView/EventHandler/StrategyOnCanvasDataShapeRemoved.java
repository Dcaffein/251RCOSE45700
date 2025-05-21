package CanvasApp.View.CanvasView.EventHandler;

import CanvasApp.View.CanvasView.CanvasViewContext;
import CanvasApp.ViewModel.Data.CanvasData.Event.CanvasDataEvent;
import CanvasApp.ViewModel.Data.CanvasData.Event.CanvasDataShapeRemoved;

import java.awt.*;

public class StrategyOnCanvasDataShapeRemoved extends StrategyHandlingCanvasView {
    public StrategyOnCanvasDataShapeRemoved(CanvasDataEventHandler canvasDataEventHandler) {
        super(canvasDataEventHandler);
    }

    @Override
    public void handle(CanvasDataEvent<?> event) {
        if(event instanceof CanvasDataShapeRemoved e) {
            CanvasViewContext canvasViewContext = canvasDataEventHandler.canvasViewContext;
            Component component = canvasViewContext.findComponentById(e.source.getId());
            canvasViewContext.removeChildViewOnLayeredPane(component);
        }
    }
}

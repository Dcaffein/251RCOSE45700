package CanvasApp.View.CanvasView.EventHandler;

import CanvasApp.View.CanvasView.CanvasViewContext;
import CanvasApp.ViewModel.Data.CanvasData.Event.*;

import java.util.HashMap;
import java.util.Map;

public class CanvasDataEventHandler implements CanvasDataObserver {
    public CanvasViewContext canvasViewContext;

    private final Map<Class<? extends CanvasDataEvent<?>>, HandleCanvasView> handlingStrategies = new HashMap<>();

    public CanvasDataEventHandler(CanvasViewContext canvasViewContext) {
        this.canvasViewContext = canvasViewContext;
        initializeEventHandlers();
    }

    private void initializeEventHandlers() {
        handlingStrategies.put(CanvasDataShapeAdded.class,new HandleCanvasDataShapeAdded(this));
        handlingStrategies.put(CanvasDataShapeRemoved.class,new HandleCanvasDataShapeRemoved(this));
        handlingStrategies.put(CanvasDataShapeRealigned.class,new HandleCanvasDataShapeRealigned(this));
        handlingStrategies.put(CanvasDataDraggableSet.class,new HandleCanvasDataDraggableSet(this));
    }

    @Override
    public void onUpdate(CanvasDataEvent<?> event) {
        HandleCanvasView strategy = handlingStrategies.get(event.getClass());
        if (strategy != null) {
            strategy.handle(event);
        }
    }
}

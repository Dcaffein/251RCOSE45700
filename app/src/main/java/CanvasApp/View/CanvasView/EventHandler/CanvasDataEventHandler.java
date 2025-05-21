package CanvasApp.View.CanvasView.EventHandler;

import CanvasApp.View.CanvasView.CanvasViewContext;
import CanvasApp.ViewModel.Data.CanvasData.Event.*;

import java.util.HashMap;
import java.util.Map;

public class CanvasDataEventHandler implements CanvasDataObserver {
    public CanvasViewContext canvasViewContext;

    private final Map<Class<? extends CanvasDataEvent<?>>, StrategyHandlingCanvasView> handlingStrategies = new HashMap<>();

    public CanvasDataEventHandler(CanvasViewContext canvasViewContext) {
        this.canvasViewContext = canvasViewContext;
        initializeEventHandlers();
    }

    private void initializeEventHandlers() {
        handlingStrategies.put(CanvasDataShapeAdded.class,new StrategyOnCanvasDataShapeAdded(this));
        handlingStrategies.put(CanvasDataShapeRemoved.class,new StrategyOnCanvasDataShapeRemoved(this));
        handlingStrategies.put(CanvasDataShapeRealigned.class,new StrategyOnCanvasDataShapeRealigned(this));
        handlingStrategies.put(CanvasDataDraggableSet.class,new StrategyOnCanvasDataDraggableSet(this));
    }

    @Override
    public void onUpdate(CanvasDataEvent<?> event) {
        StrategyHandlingCanvasView strategy = handlingStrategies.get(event.getClass());
        if (strategy != null) {
            strategy.handle(event);
        }
    }
}

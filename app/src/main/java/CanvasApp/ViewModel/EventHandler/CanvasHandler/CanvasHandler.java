package CanvasApp.ViewModel.EventHandler.CanvasHandler;

import CanvasApp.Model.Event.*;
import CanvasApp.ViewModel.Data.CanvasData.CanvasData;
import CanvasApp.ViewModel.EventHandler.CanvasHandler.Strategy.*;

import java.util.HashMap;
import java.util.Map;

public class CanvasHandler implements ShapeObserver {
    public final CanvasData canvasData;

    private final Map<Class<? extends ShapeEvent>, StrategyHandlingCanvas> handlingStrategies = new HashMap<>();

    public CanvasHandler(CanvasData canvasData) {
        this.canvasData = canvasData;
        initializeEventHandlers();
    }

    private void initializeEventHandlers() {
        handlingStrategies.put(ShapeModelAdded.class, new StrategyOnShapeAdded(this));
        handlingStrategies.put(ShapeModelRemoved.class, new StrategyOnShapeRemoved(this));
        handlingStrategies.put(ShapeModelMoved.class, new StrategyOnShapeMoved(this));
        handlingStrategies.put(ShapeModelResized.class, new StrategyOnShapeResized(this));
        handlingStrategies.put(ShapeModelRealigned.class, new StrategyOnShapeRealigned(this));
        handlingStrategies.put(ShapeModelTextChanged.class, new StrategyOnShapeTextChanged(this));
    }

    @Override
    public void onUpdate(ShapeEvent event) {
        StrategyHandlingCanvas strategy = handlingStrategies.get(event.getClass());
        if(strategy != null) {
            strategy.handle(event);
        }
    }

}
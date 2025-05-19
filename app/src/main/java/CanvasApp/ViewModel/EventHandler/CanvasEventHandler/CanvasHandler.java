package CanvasApp.ViewModel.EventHandler.CanvasEventHandler;

import CanvasApp.Model.Event.*;
import CanvasApp.ViewModel.Data.CanvasData.CanvasData;

import java.util.HashMap;
import java.util.Map;

public class CanvasHandler implements ShapeObserver {
    public final CanvasData canvasData;

    private final Map<Class<? extends ShapeEvent>, HandleCanvas> handlingStrategies = new HashMap<>();

    public CanvasHandler(CanvasData canvasData) {
        this.canvasData = canvasData;
        initializeEventHandlers();
    }

    private void initializeEventHandlers() {
        handlingStrategies.put(ShapeModelAdded.class, new HandleShapeAdded(this));
        handlingStrategies.put(ShapeModelRemoved.class, new HandleShapeRemoved(this));
        handlingStrategies.put(ShapeModelMoved.class, new HandleShapeMoved(this));
        handlingStrategies.put(ShapeModelResized.class, new HandleShapeResized(this));
        handlingStrategies.put(ShapeModelRealigned.class, new HandleShapeRealigned(this));
        handlingStrategies.put(ShapeModelTextChanged.class, new HandleShapeTextChanged(this));
    }

    @Override
    public void onUpdate(ShapeEvent event) {
        HandleCanvas strategy = handlingStrategies.get(event.getClass());
        if(strategy != null) {
            strategy.handle(event);
        }
    }

}
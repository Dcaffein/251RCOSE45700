package CanvasApp.View.ShapeView.EventHandler;

import CanvasApp.View.ShapeView.EventHandler.Strategy.HandleShapeDataMoved;
import CanvasApp.View.ShapeView.EventHandler.Strategy.HandleShapeDataResized;
import CanvasApp.View.ShapeView.ShapeViewContext;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataEvent;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataMoved;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataObserver;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataResized;

import java.util.HashMap;
import java.util.Map;

public class ShapeDataEventHandler implements ShapeDataObserver {
    public ShapeViewContext shapeViewContext;

    private final Map<Class<? extends ShapeDataEvent>, StrategyShapeView> handlingStrategies = new HashMap<>();

    public ShapeDataEventHandler(ShapeViewContext shapeViewContext) {
        this.shapeViewContext = shapeViewContext;
        initializeEventHandlers();
    }

    private void initializeEventHandlers() {
        handlingStrategies.put(ShapeDataMoved.class, new HandleShapeDataMoved(this));
        handlingStrategies.put(ShapeDataResized.class, new HandleShapeDataResized(this));
    }

    @Override
    public void onUpdate(ShapeDataEvent event) {
        StrategyShapeView strategy = handlingStrategies.get(event.getClass());
        if (strategy != null) {
            strategy.handle(event);
        }
    }
}

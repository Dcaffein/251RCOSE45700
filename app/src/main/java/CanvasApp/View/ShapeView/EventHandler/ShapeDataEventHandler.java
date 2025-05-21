package CanvasApp.View.ShapeView.EventHandler;

import CanvasApp.View.ShapeView.EventHandler.Strategy.StrategyOnShapeDataMoved;
import CanvasApp.View.ShapeView.EventHandler.Strategy.StrategyOnShapeDataResized;
import CanvasApp.View.ShapeView.EventHandler.Strategy.StrategyOnShapeDataSelected;
import CanvasApp.View.ShapeView.ShapeViewContext;
import CanvasApp.ViewModel.Data.ShapeData.Event.*;

import java.util.HashMap;
import java.util.Map;

public class ShapeDataEventHandler implements ShapeDataObserver {
    public ShapeViewContext shapeViewContext;

    private final Map<Class<? extends ShapeDataEvent>, StrategyHandlingShapeView> handlingStrategies = new HashMap<>();

    public ShapeDataEventHandler(ShapeViewContext shapeViewContext) {
        this.shapeViewContext = shapeViewContext;
        initializeEventHandlers();
    }

    private void initializeEventHandlers() {
        handlingStrategies.put(ShapeDataMoved.class, new StrategyOnShapeDataMoved(this));
        handlingStrategies.put(ShapeDataResized.class, new StrategyOnShapeDataResized(this));
        handlingStrategies.put(ShapeDataSelected.class, new StrategyOnShapeDataSelected(this));
    }

    @Override
    public void onUpdate(ShapeDataEvent event) {
        StrategyHandlingShapeView strategy = handlingStrategies.get(event.getClass());
        if (strategy != null) {
            strategy.handle(event);
        }
    }
}

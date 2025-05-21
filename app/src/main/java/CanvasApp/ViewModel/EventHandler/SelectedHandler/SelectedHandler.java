package CanvasApp.ViewModel.EventHandler.SelectedHandler;

import CanvasApp.Model.Event.ShapeEvent;
import CanvasApp.Model.Event.ShapeModelAdded;
import CanvasApp.Model.Event.ShapeModelRemoved;
import CanvasApp.Model.Event.ShapeObserver;
import CanvasApp.ViewModel.Data.CanvasData.CanvasData;
import CanvasApp.ViewModel.Data.PropertyData.PropertyData;

import java.util.HashMap;
import java.util.Map;

public class SelectedHandler implements ShapeObserver {
    public PropertyData propertyData;
    public CanvasData canvasData;

    private final Map<Class<? extends ShapeEvent>, StrategyHandlingSelected> handlingStrategies = new HashMap<>();
    private StrategyHandlingSelected baseStrategy;

    public SelectedHandler(PropertyData propertyData, CanvasData canvasData) {
        this.propertyData = propertyData;
        this.canvasData = canvasData;
        initializeEventHandlers();
    }

    private void initializeEventHandlers() {
        baseStrategy = new StrategyOnBaseEvent(this);
        handlingStrategies.put(ShapeModelAdded.class,new StrategyOnShapeAdded(this));
        handlingStrategies.put(ShapeModelRemoved.class,new StrategyOnShapeRemoved(this));
    }

    @Override
    public void onUpdate(ShapeEvent event) {
        baseStrategy.handle(event);

        StrategyHandlingSelected strategy = handlingStrategies.get(event.getClass());
        if(strategy!=null) {
            strategy.handle(event);
        }
    }
}

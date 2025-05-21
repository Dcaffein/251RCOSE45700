package CanvasApp.View.PropertyView.EventHandler;

import CanvasApp.Model.Event.ShapeEvent;
import CanvasApp.View.PropertyView.PropertyViewContext;
import CanvasApp.ViewModel.Data.PropertyData.Event.PropertyDataChanged;
import CanvasApp.ViewModel.Data.PropertyData.Event.PropertyDataObserver;

import java.util.HashMap;
import java.util.Map;

public class PropertyDataEventHandler implements PropertyDataObserver {
    public final PropertyViewContext propertyViewContext;

    private final Map<Class<? extends ShapeEvent>, StrategyHandlingPropertyView> handlingStrategies = new HashMap<>();

    private StrategyHandlingPropertyView currentStrategy;

    public PropertyDataEventHandler(PropertyViewContext propertyViewContext) {
        this.propertyViewContext = propertyViewContext;
        initializeEventHandlers();
    }

    private void initializeEventHandlers() {
        currentStrategy = new HandleSelectedUpdated(this);
    }

    @Override
    public void onUpdate(PropertyDataChanged event) {
        currentStrategy.handle(event);
//        System.out.println("[PropertyDataEventHandler] : " + currentStrategy.getClass().getName());
    }
}

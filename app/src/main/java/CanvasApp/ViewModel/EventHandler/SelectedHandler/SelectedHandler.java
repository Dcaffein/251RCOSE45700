package CanvasApp.ViewModel.EventHandler.SelectedHandler;

import CanvasApp.Model.Event.ShapeEvent;
import CanvasApp.Model.Event.ShapeObserver;
import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.Data.PropertyData.PropertyData;

public class SelectedHandler implements ShapeObserver {
    public PropertyData propertyData;

//    private final Map<Class<? extends ShapeEvent>, HandleSelected> handlingStrategies = new HashMap<>();
    private StrategyHandlingSelected currentStrategy; //default strategy

    public SelectedHandler(ShapeModel selected, PropertyData propertyData) {
        this.propertyData = propertyData;
        initializeEventHandlers();
    }

    private void initializeEventHandlers() {
        currentStrategy = new StrategyOnSelectedUpdated(this);
    }

    @Override
    public void onUpdate(ShapeEvent event) {
        currentStrategy.handle(event);
    }
}

package CanvasApp.View.ShapeView.EventHandler;

import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataEvent;
import Observer.EventHandlingStrategy;

public abstract class StrategyHandlingShapeView implements EventHandlingStrategy<ShapeDataEvent> {
    public ShapeDataEventHandler shapeDataEventHandler;

    public StrategyHandlingShapeView(ShapeDataEventHandler shapeDataEventHandler) {
        this.shapeDataEventHandler = shapeDataEventHandler;
    }
}

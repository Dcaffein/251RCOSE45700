package CanvasApp.View.ShapeView.EventHandler;

import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataEvent;
import Observer.EventHandlingStrategy;

public abstract class StrategyShapeView implements EventHandlingStrategy<ShapeDataEvent> {
    public ShapeDataEventHandler shapeDataEventHandler;

    public StrategyShapeView(ShapeDataEventHandler shapeDataEventHandler) {
        this.shapeDataEventHandler = shapeDataEventHandler;
    }
}

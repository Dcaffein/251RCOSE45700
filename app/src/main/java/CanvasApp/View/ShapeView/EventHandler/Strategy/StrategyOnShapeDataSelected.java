package CanvasApp.View.ShapeView.EventHandler.Strategy;

import CanvasApp.View.ShapeView.EventHandler.ShapeDataEventHandler;
import CanvasApp.View.ShapeView.EventHandler.StrategyHandlingShapeView;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataEvent;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataSelected;

public class StrategyOnShapeDataSelected extends StrategyHandlingShapeView {
    public StrategyOnShapeDataSelected(ShapeDataEventHandler shapeDataEventHandler) {
        super(shapeDataEventHandler);
    }

    @Override
    public void handle(ShapeDataEvent event) {
        if(event instanceof ShapeDataSelected e) {
            shapeDataEventHandler.shapeViewContext.repaint();
        }
    }
}

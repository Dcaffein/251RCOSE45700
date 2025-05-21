package CanvasApp.View.ShapeView.EventHandler.Strategy;

import CanvasApp.View.ShapeView.EventHandler.ShapeDataEventHandler;
import CanvasApp.View.ShapeView.EventHandler.StrategyHandlingShapeView;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataEvent;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataMoved;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

public class StrategyOnShapeDataMoved extends StrategyHandlingShapeView {
    public StrategyOnShapeDataMoved(ShapeDataEventHandler shapeDataEventHandler) {
        super(shapeDataEventHandler);
    }

    @Override
    public void handle(ShapeDataEvent event) {
        if(event instanceof ShapeDataMoved e) {
            ShapeData shapeData = e.source;
            shapeDataEventHandler.shapeViewContext.setBounds(shapeData.getX(), shapeData.getY(), shapeData.getW(), shapeData.getH());
        }
    }
}

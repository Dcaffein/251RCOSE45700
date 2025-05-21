package CanvasApp.View.ShapeView.EventHandler.Strategy;

import CanvasApp.View.ShapeView.EventHandler.ShapeDataEventHandler;
import CanvasApp.View.ShapeView.EventHandler.StrategyHandlingShapeView;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataEvent;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataResized;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

public class StrategyOnShapeDataResized extends StrategyHandlingShapeView {
    public StrategyOnShapeDataResized(ShapeDataEventHandler shapeDataEventHandler) {
        super(shapeDataEventHandler);
    }

    @Override
    public void handle(ShapeDataEvent event) {
        if(event instanceof ShapeDataResized e){
            ShapeData shapeData = e.source;
            shapeDataEventHandler.shapeViewContext.setBounds(shapeData.getX(),shapeData.getY(),shapeData.getW(),shapeData.getH());
            shapeDataEventHandler.shapeViewContext.repaint();
        }
    }
}

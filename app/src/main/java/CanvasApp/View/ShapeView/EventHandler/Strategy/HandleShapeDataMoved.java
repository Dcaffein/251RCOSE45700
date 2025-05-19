package CanvasApp.View.ShapeView.EventHandler.Strategy;

import CanvasApp.View.ShapeView.EventHandler.ShapeDataEventHandler;
import CanvasApp.View.ShapeView.EventHandler.StrategyShapeView;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataEvent;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

public class HandleShapeDataMoved extends StrategyShapeView {
    public HandleShapeDataMoved(ShapeDataEventHandler shapeDataEventHandler) {
        super(shapeDataEventHandler);
    }

    @Override
    public void handle(ShapeDataEvent event) {
        ShapeData shapeData = event.source;
        shapeDataEventHandler.shapeViewContext.setBounds(shapeData.getX(),shapeData.getY(),shapeData.getW(),shapeData.getH());
    }
}

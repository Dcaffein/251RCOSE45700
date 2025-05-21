package CanvasApp.View.CanvasView.EventHandler;

import CanvasApp.View.CanvasView.CanvasViewContext;
import CanvasApp.View.ShapeView.Decorator.ShapeViewDecorator;
import CanvasApp.View.ShapeView.ShapeView;
import CanvasApp.ViewModel.Data.CanvasData.Event.CanvasDataEvent;
import CanvasApp.ViewModel.Data.CanvasData.Event.CanvasDataShapeAdded;
import CanvasApp.ViewModel.Data.ShapeData.Decorator.ShapeDataDecorator;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

public class StrategyOnCanvasDataShapeAdded extends StrategyHandlingCanvasView {
    public StrategyOnCanvasDataShapeAdded(CanvasDataEventHandler canvasDataEventHandler) {
        super(canvasDataEventHandler);
    }

    @Override
    public void handle(CanvasDataEvent<?> event) {
        if(event instanceof CanvasDataShapeAdded e){
            CanvasViewContext canvasViewContext = canvasDataEventHandler.canvasViewContext;
            ShapeView shapeView;
            ShapeData shapeData = e.source;

            if(e.source instanceof ShapeDataDecorator){
                ShapeView nestedView = canvasViewContext.createChildShapeView(shapeData);
                ShapeView decoratedView = nestedView;
                while (decoratedView instanceof ShapeViewDecorator){
                    decoratedView = ((ShapeViewDecorator) decoratedView).getDecorated();
                }
                shapeView = decoratedView;
                decoratedView = nestedView;
                while(decoratedView instanceof ShapeViewDecorator) {
                    decoratedView.setBounds(0,0,shapeData.getW(),shapeData.getH());
                    shapeView.add(decoratedView);
                    decoratedView = ((ShapeViewDecorator) decoratedView).getDecorated();
                }
            }
            else {
                shapeView = canvasViewContext.createChildShapeView(shapeData);                              }
                canvasViewContext.addChildViewOnLayeredPane(shapeView);
                shapeView.setBounds(shapeData.getX(),shapeData.getY(),shapeData.getW(),shapeData.getH());
                canvasViewContext.setChildViewLayerOnLayeredPane(shapeView,shapeData.getZ());
                canvasViewContext.repaint();
        }
    }
}

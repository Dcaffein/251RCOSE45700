package CanvasApp.View.CanvasView.EventHandler;

import CanvasApp.View.CanvasView.CanvasViewContext;
import CanvasApp.View.ShapeView.Decorator.Text.ShapeDecoratorView;
import CanvasApp.View.ShapeView.ShapeView;
import CanvasApp.ViewModel.Data.CanvasData.Event.CanvasDataEvent;
import CanvasApp.ViewModel.Data.CanvasData.Event.CanvasDataShapeAdded;
import CanvasApp.ViewModel.Data.ShapeData.Decorator.ShapeDataDecorator;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

public class HandleCanvasDataShapeAdded extends HandleCanvasView{
    public HandleCanvasDataShapeAdded(CanvasDataEventHandler canvasDataEventHandler) {
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
                while (decoratedView instanceof ShapeDecoratorView){
                    decoratedView = ((ShapeDecoratorView) decoratedView).getDecorated();
                }
                shapeView = decoratedView;
                decoratedView = nestedView;
                while(decoratedView instanceof ShapeDecoratorView) {
                    decoratedView.setBounds(0,0,shapeData.getW(),shapeData.getH());
                    shapeView.add(decoratedView);
                    decoratedView = ((ShapeDecoratorView) decoratedView).getDecorated();
                }
            }

            else {
                shapeView = canvasViewContext.createChildShapeView(shapeData);
            }
            canvasViewContext.addChildViewOnLayeredPane(shapeView);
            shapeView.setBounds(shapeData.getX(),shapeData.getY(),shapeData.getW(),shapeData.getH());
            canvasViewContext.setChildViewLayerOnLayeredPane(shapeView,shapeData.getZ());
            canvasViewContext.repaint();
        }
    }
}

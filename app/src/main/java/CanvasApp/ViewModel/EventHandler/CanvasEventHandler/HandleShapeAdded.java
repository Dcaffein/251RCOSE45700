package CanvasApp.ViewModel.EventHandler.CanvasEventHandler;

import CanvasApp.Factory.ShapeFactory;
import CanvasApp.Factory.ShapeFactoryRegistry;
import CanvasApp.Model.Event.ShapeEvent;
import CanvasApp.Model.Event.ShapeModelAdded;
import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

public class HandleShapeAdded extends HandleCanvas {
    public HandleShapeAdded(CanvasHandler context) {
        super(context);
    }

    @Override
    public void handle(ShapeEvent event) {
        if(event instanceof ShapeModelAdded) {
            ShapeModel shapeModel = event.source;
            ShapeFactory factory = ShapeFactoryRegistry.factoryFor(shapeModel);
            ShapeData shapeData = factory.createShapeData(shapeModel);
            context.canvasData.addShape(shapeData);
            shapeModel.attach(context);
        }
    }
}

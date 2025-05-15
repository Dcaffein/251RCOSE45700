package CanvasApp.ViewModel.EventHandler;

import CanvasApp.Factory.ShapeFactory;
import CanvasApp.Factory.ShapeFactoryRegistry;
import CanvasApp.Model.Shape.Event.ShapeComposition.ShapeCompositionObserver;
import CanvasApp.Model.Shape.Event.ShapeComposition.ShapeModelAdded;
import CanvasApp.Model.Shape.Event.ShapeComposition.ShapeModelRemoved;
import CanvasApp.Model.Shape.Event.ShapeUpdate.ShapeModelMoved;
import CanvasApp.Model.Shape.Event.ShapeUpdate.ShapeModelRealigned;
import CanvasApp.Model.Shape.Event.ShapeUpdate.ShapeModelResized;
import CanvasApp.Model.Shape.Event.ShapeUpdate.ShapeUpdateObserver;
import CanvasApp.ViewModel.Datas.CanvasData.CanvasData;
import CanvasApp.ViewModel.Datas.ShapeData.ShapeData;

public class CanvasEventHandler implements ShapeCompositionObserver, ShapeUpdateObserver {

    private final CanvasData canvasData;
    public CanvasEventHandler(CanvasData canvasData) {
        this.canvasData = canvasData;
    }

    @Override
    public void onShapeAdded(ShapeModelAdded event) {
        ShapeFactory factory = ShapeFactoryRegistry.factoryFor(event.source);
        ShapeData shapeData = factory.createShapeData(event.source);
        canvasData.addShape(shapeData, factory);
        event.source.attach(this);
        System.out.println("[CanvasCompositionHandler] updateHandler attached for id="
                + event.source.getId());
    }

    @Override
    public void onShapeRemoved(ShapeModelRemoved event) {
        canvasData.removeShape(event.source.getId());
    }

    @Override
    public void onShapeMoved(ShapeModelMoved event) {
        ShapeData shapeData = canvasData.getShapeData(event.source.getId());
        shapeData.updatePosition(event.source.getX(), event.source.getY());
    }

    @Override
    public void onShapeResized(ShapeModelResized event) {
        ShapeData shapeData = canvasData.getShapeData(event.source.getId());
        shapeData.updateSize(event.source.getW(), event.source.getH());
    }

    @Override
    public void onShapeRealigned(ShapeModelRealigned event) {
        ShapeData shapeData = canvasData.getShapeData(event.source.getId());
        shapeData.updateZ(event.source.getZ());
        canvasData.realign(shapeData);
    }
}
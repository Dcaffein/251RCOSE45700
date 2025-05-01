package CanvasApp.ViewModel.CanvasData.Observer;

import CanvasApp.Model.Factory.ShapeFactory;

public class CanvasDataShapeAdded extends CanvasDataEvent {
    public ShapeFactory shapeFactory;
    public String id;

    public CanvasDataShapeAdded(String id, ShapeFactory shapeFactory) {
        this.id=id;
        this.shapeFactory = shapeFactory;
    }

    @Override
    public void dispatchCanvasDataEvent(CanvasDataObserver o) {
        o.onShapeAdded(this);
    }
}

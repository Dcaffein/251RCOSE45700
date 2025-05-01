package CanvasApp.Model.Canvas.Observer;

import CanvasApp.Model.Factory.ShapeFactory;

public abstract class CanvasModelShapeAdded extends CanvasModelEvent {
    public abstract ShapeFactory getShapeFactory();
    public CanvasModelShapeAdded(String id){
        super(id);
    }

    @Override
    public void dispatchCanvasModelEvent(CanvasModelObserver o) {
        o.onShapeAdded(this);
    }
}

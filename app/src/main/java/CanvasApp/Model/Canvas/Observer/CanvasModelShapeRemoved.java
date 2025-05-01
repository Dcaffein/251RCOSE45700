package CanvasApp.Model.Canvas.Observer;

public class CanvasModelShapeRemoved extends CanvasModelEvent {
    public CanvasModelShapeRemoved(String id){
        super(id);
    }

    @Override
    public void dispatchCanvasModelEvent(CanvasModelObserver o) {
        o.onShapeRemoved(this);
    }
}
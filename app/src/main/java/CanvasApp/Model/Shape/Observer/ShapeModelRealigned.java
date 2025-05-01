package CanvasApp.Model.Shape.Observer;

public class ShapeModelRealigned extends ShapeModelEvent {
    public int z;
    public ShapeModelRealigned(String id, int z){
        super(id);
        this.z = z;
    }

    @Override
    public void dispatchShapeModelEvent(ShapeModelObserver o) {
        o.onRealigned(this);
    }
}
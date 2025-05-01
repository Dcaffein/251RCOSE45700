package CanvasApp.Model.Shape.Observer;

public class ShapeModelMoved extends ShapeModelEvent {
    public int x; public int y;
    public ShapeModelMoved(String id, int x, int y) {
        super(id);
        this.x = x;
        this.y = y;
    }
    @Override
    public void dispatchShapeModelEvent(ShapeModelObserver o) {
        o.onMoved(this);
    }
}

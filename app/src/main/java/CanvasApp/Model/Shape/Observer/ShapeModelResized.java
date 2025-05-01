package CanvasApp.Model.Shape.Observer;

public class ShapeModelResized extends ShapeModelEvent {
    public int w; public int h;
    public ShapeModelResized(String id, int w, int h) {
        super(id);
        this.w = w;
        this.h = h;
    }

    @Override
    public void dispatchShapeModelEvent(ShapeModelObserver o) {
        o.onResized(this);
    }
}

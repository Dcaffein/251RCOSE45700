package CanvasApp.ViewModel.ShapeData.Observer;

public class ShapeDataResized extends ShapeDataEvent {
    public int w,h;
    public ShapeDataResized(String id,int w,int h) {
        super(id);
        this.w = w;
        this.h = h;
    }

    @Override
    public void dispatchShapeDataEvent(ShapeDataObserver o) {
        o.onResized(this);
    }
}

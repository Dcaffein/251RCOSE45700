package CanvasApp.ViewModel.ShapeData.Observer;

public class ShapeDataMoved extends ShapeDataEvent {
    public int x,y;
    public ShapeDataMoved(String id,int x, int y) {
        super(id);
        this.x = x;
        this.y = y;
    }

    @Override
    public void dispatchShapeDataEvent(ShapeDataObserver o) {
        o.onMoved(this);
    }
}

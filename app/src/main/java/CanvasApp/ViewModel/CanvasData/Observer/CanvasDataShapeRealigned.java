package CanvasApp.ViewModel.CanvasData.Observer;

public class CanvasDataShapeRealigned extends CanvasDataEvent {
    public int z;
    public String id;
    public CanvasDataShapeRealigned(String id, int z) {
        this.id=id;
        this.z = z;
    }

    @Override
    public void dispatchCanvasDataEvent(CanvasDataObserver o) {
        o.onRealigned(this);
    }
}

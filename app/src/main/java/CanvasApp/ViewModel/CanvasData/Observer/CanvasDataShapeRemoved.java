package CanvasApp.ViewModel.CanvasData.Observer;

public class CanvasDataShapeRemoved extends CanvasDataEvent {
    public String id;
    public CanvasDataShapeRemoved(String id) {
        this.id=id;
    }

    @Override
    public void dispatchCanvasDataEvent(CanvasDataObserver o) {
        o.onShapeRemoved(this);
    }
}

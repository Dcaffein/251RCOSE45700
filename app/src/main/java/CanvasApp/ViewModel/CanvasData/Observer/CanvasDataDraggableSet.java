package CanvasApp.ViewModel.CanvasData.Observer;

public class CanvasDataDraggableSet extends CanvasDataEvent {
    public boolean draggable;

    public CanvasDataDraggableSet(boolean draggable) {
        this.draggable = draggable;
    }

    @Override
    public void dispatchCanvasDataEvent(CanvasDataObserver o) {
        System.out.println("[CanvasDataDraggableSet] dispatching to observer");
        o.onCanvasDataDraggableSet(this);
    }

}

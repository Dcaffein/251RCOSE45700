package CanvasApp.View.CanvasView.EventHandler;

import CanvasApp.View.CanvasView.CanvasView;
import CanvasApp.ViewModel.CanvasViewModel.Event.MouseEventStateChanged;
import CanvasApp.ViewModel.CanvasViewModel.State.ReadyToDrag;
import Observer.Event;

public class OnMouseEventStateChanged implements CanvasViewEventHandler{
    @Override
    public void handle(CanvasView canvasView, Event<?> event) {
//        System.out.println("[CanvasViewEventHandler] onMouseStateChanged event.source : "+ event.source.getClass());
        if(event instanceof MouseEventStateChanged mouseEventStateChanged){
            if(mouseEventStateChanged.source instanceof ReadyToDrag){
                canvasView.setGlassPaneVisible(true);
            } else {
                canvasView.setGlassPaneVisible(false);
            }
        }
    }
}

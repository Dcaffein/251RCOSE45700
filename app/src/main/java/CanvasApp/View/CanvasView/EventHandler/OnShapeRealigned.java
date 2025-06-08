package CanvasApp.View.CanvasView.EventHandler;

import CanvasApp.Model.ShapeModel;
import CanvasApp.View.CanvasView.CanvasView;
import CanvasApp.Model.Event.ShapeAdded;
import Observer.Event;

import java.awt.*;

public class OnShapeRealigned implements CanvasViewEventHandler {
    @Override
    public void handle(CanvasView canvasView, Event<?> event) {
        ShapeModel model = ((ShapeAdded)event).source;
        Component child = canvasView.findComponentById(model.getId());
        canvasView.setChildViewLayerOnLayeredPane(child,model.getZ());
    }
}

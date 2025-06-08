package CanvasApp.View.ShapeView.EventHandler;

import CanvasApp.View.ShapeView.ShapeView;
import Observer.Event;

public class OnShapeSelected implements ShapeViewEventHandler {
    @Override
    public void handle(ShapeView shapeView, Event<?> event) {
        shapeView.repaint();
    }
}

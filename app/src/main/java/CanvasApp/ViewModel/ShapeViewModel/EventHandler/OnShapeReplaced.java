package CanvasApp.ViewModel.ShapeViewModel.EventHandler;

import CanvasApp.Model.Decorator.ShapeDecorator;
import CanvasApp.ViewModel.ShapeViewModel.ShapeViewModel;
import Observer.Event;

public class OnShapeReplaced implements ShapeViewModelEventHandler {
    @Override
    public void handle(ShapeViewModel shapeViewModel, Event<?> event) {
        if(event.source instanceof ShapeDecorator decorator){
            shapeViewModel.setShape(decorator);
            shapeViewModel.notify(event);
        }
    }
}

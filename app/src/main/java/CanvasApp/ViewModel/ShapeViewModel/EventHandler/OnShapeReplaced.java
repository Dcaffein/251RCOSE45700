package CanvasApp.ViewModel.ShapeViewModel.EventHandler;

import CanvasApp.Model.Decorator.ShapeDecorator;
import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.ShapeViewModel.Event.DecoCompositionChanged;
import CanvasApp.ViewModel.ShapeViewModel.ShapeViewModel;
import Observer.Event;

public class OnShapeReplaced implements ShapeViewModelEventHandler {
    @Override
    public void handle(ShapeViewModel shapeViewModel, Event<?> event) {
        if(event.source instanceof ShapeModel newModel){
            System.out.println("[ShapeViewModel] OnShapeReplaced: " + newModel);
            shapeViewModel.setShape(newModel);
            if(newModel instanceof ShapeDecorator decorator){
                shapeViewModel.notify(new DecoCompositionChanged(decorator));
            }
        }
    }
}

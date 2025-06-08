package CanvasApp.ViewModel.ShapeViewModel.EventHandler;

import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.SelectionManager.Event.ShapeUnselected;
import CanvasApp.ViewModel.ShapeViewModel.ShapeViewModel;
import Observer.Event;

public class OnShapeUnselected implements ShapeViewModelEventHandler {
    @Override
    public void handle(ShapeViewModel shapeViewModel, Event<?> event) {
        if(event instanceof ShapeUnselected shapeUnselected){
            ShapeModel shape = shapeUnselected.source;
//            System.out.println("shape.getChild(shapeViewModel.shape.getId()) : " + shape.getChild(shapeViewModel.shape.getId()) );
            if(shape.getChild(shapeViewModel.shape.getId())==null){
                shapeViewModel.setSelected(false);
            }
        }
    }
}

package CanvasApp.ViewModel.ShapeViewModel.EventHandler;

import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.SelectionManager.Event.ShapeUnselected;
import CanvasApp.ViewModel.ShapeViewModel.ShapeViewModel;
import Observer.Event;

import java.util.List;
import java.util.Objects;

public class OnShapeUnselected implements ShapeViewModelEventHandler {
    @Override
    public void handle(ShapeViewModel shapeViewModel, Event<?> event) {
        if(event instanceof ShapeUnselected shapeUnselected){
            List<ShapeModel> unselected = shapeUnselected.source;
//            System.out.println("ShapeVM On Unselected List : "+shapeUnselected.source);
//            System.out.println("ShapeVM On Unselected shapeViewModel.getShape(): "+shapeViewModel.getShape());
            for(ShapeModel shapeModel : unselected){
                if(Objects.equals(shapeViewModel.getShape().getId(), shapeModel.getId())){
                    shapeViewModel.setSelected(false);
                    return;
                }
            }
        }
    }
}

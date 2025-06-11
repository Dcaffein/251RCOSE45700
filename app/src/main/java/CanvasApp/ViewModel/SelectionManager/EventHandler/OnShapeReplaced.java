package CanvasApp.ViewModel.SelectionManager.EventHandler;

import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.SelectionManager.SelectionManager;
import Observer.Event;

public class OnShapeReplaced implements SelectionManagerEventHandler{
    @Override
    public void handle(SelectionManager selectionManager, Event<?> event) {
        if(event.source instanceof ShapeModel newOne){
            ShapeModel oldOne = selectionManager.getShape(newOne.getId());
            if(oldOne != null){
                oldOne.detach(selectionManager);
                System.out.println("[SelectionManager onShapeReplaced] oldOne: " + oldOne);
                System.out.println("[SelectionManager onShapeReplaced] newOne: " + newOne);
                selectionManager.add(newOne);
            }
        }
    }
}

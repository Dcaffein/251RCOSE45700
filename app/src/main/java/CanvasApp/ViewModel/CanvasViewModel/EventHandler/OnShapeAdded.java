package CanvasApp.ViewModel.CanvasViewModel.EventHandler;

import CanvasApp.Factory.ShapeViewModelFactory.ShapeViewModelFactory;
import CanvasApp.ViewModel.ShapeViewModel.ShapeViewModel;
import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.CanvasViewModel.CanvasViewModel;
import Observer.Event;
import CanvasApp.ViewModel.CanvasViewModel.Event.ShapeVMAdded;

public class OnShapeAdded implements CanvasViewModelEventHandler {
    @Override
    public void handle(CanvasViewModel canvasViewModel, Event<?> event) {
        ShapeModel shape = ((ShapeModel)event.source);
        shape.attach(canvasViewModel);
        canvasViewModel.updateMaxZ(shape.getZ());

        ShapeViewModel shapeViewModel = ShapeViewModelFactory.getInstance().createShapeViewModel(shape);
        canvasViewModel.notify(new ShapeVMAdded(shapeViewModel));
        System.out.println("[CanvasVM EventHandler] OnShapeAdded : " + shapeViewModel.shape.getId());
    }
}

package CanvasApp.View.CanvasView.EventHandler;

import CanvasApp.Factory.ShapeViewFactory.ShapeViewFactory;
import CanvasApp.View.ShapeView.ShapeView;
import CanvasApp.ViewModel.ShapeViewModel.ShapeViewModel;
import CanvasApp.ViewModel.CanvasViewModel.Event.ShapeVMAdded;

import CanvasApp.View.CanvasView.CanvasView;
import Observer.Event;

public class OnShapeAdded implements CanvasViewEventHandler {
    @Override
    public void handle(CanvasView canvasView, Event<?> event) {
        ShapeViewModel viewModel = ((ShapeVMAdded)event).source;
        ShapeView view = ShapeViewFactory.getInstance().createShapeView(viewModel);
        canvasView.addChildViewOnLayeredPane(view);
    }
}

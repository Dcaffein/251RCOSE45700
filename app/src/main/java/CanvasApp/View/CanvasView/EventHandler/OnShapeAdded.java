package CanvasApp.View.CanvasView.EventHandler;

import CanvasApp.Factory.ShapeView.ShapeViewFactory;
import CanvasApp.View.ShapeView.ShapeView;
import CanvasApp.ViewModel.ShapeViewModel.ShapeViewModel;

import CanvasApp.View.CanvasView.CanvasView;
import Observer.Event;

public class OnShapeAdded implements CanvasViewEventHandler {
    @Override
    public void handle(CanvasView canvasView, Event<?> event) {
        System.out.println("[CanvasViewEventHandler] OnShapeAdded: " + event.getClass());
        ShapeViewModel viewModel = (ShapeViewModel) event.source;
        ShapeView view = ShapeViewFactory.getInstance().createShapeView(viewModel);
        canvasView.addChildViewOnLayeredPane(view);
        canvasView.setChildViewLayerOnLayeredPane(view,viewModel.getShape().getZ());
    }
}

package CanvasApp.View.ShapeView.EventHandler;

import CanvasApp.Model.ShapeModel;
import CanvasApp.View.ShapeView.ShapeView;
import Observer.Event;

public class OnShapeMoved implements ShapeViewEventHandler {
    @Override
    public void handle(ShapeView shapeView, Event<?> event) {
        ShapeModel shape = shapeView.viewModel.shape;
        shapeView.setBounds(shape.getX(),shape.getY(),shape.getW(),shape.getH());
    }
}
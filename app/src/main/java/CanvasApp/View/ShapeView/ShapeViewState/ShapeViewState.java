package CanvasApp.View.ShapeView.ShapeViewState;

import CanvasApp.View.ShapeView.ConcreteShapeView;
import CanvasApp.View.ShapeView.ShapeView;

import java.awt.event.MouseEvent;

public abstract class ShapeViewState {
    ConcreteShapeView shapeView;

    public ShapeViewState(ConcreteShapeView shapeView) {
        this.shapeView = shapeView;
    }
    public abstract void onMousePressed(MouseEvent e);
    public abstract void onMouseReleased(MouseEvent e);
    public abstract void onMouseDragged(MouseEvent e);
}

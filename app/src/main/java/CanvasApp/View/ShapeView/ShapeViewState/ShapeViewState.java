package CanvasApp.View.ShapeView.ShapeViewState;

import java.awt.event.MouseEvent;

public abstract class ShapeViewState {
    ShapeViewContext shapeView;

    public ShapeViewState(ShapeViewContext shapeView) {
        this.shapeView = shapeView;
    }
    public abstract void onMousePressed(MouseEvent e);
    public abstract void onMouseReleased(MouseEvent e);
    public abstract void onMouseDragged(MouseEvent e);
}

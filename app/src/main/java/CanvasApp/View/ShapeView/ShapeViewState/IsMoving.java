package CanvasApp.View.ShapeView.ShapeViewState;

import java.awt.*;
import java.awt.event.MouseEvent;

public class IsMoving extends ShapeViewState{
    public IsMoving(ShapeViewContext shapeView) {
        super(shapeView);
    }

    @Override
    public void onMousePressed(MouseEvent e){}

    @Override
    public void onMouseReleased(MouseEvent e) {
        shapeView.setCurrentState(new IsReadyToSelect(shapeView));
        shapeView.setDragStart(null);
    }

    @Override
    public void onMouseDragged(MouseEvent e) {
        if(shapeView.getDragStart()==null) shapeView.setCurrentState(new IsReadyToSelect(shapeView));

        Point dragEnd = e.getPoint();
        int dx = dragEnd.x - shapeView.getDragStart().x;
        int dy = dragEnd.y - shapeView.getDragStart().y;

        shapeView.moveShape(dx, dy);
        shapeView.setDragStart(dragEnd);
    }
}

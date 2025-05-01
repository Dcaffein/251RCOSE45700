package CanvasApp.View.ShapeView.ShapeViewState;


import java.awt.*;
import java.awt.event.MouseEvent;

public class IsResizing extends ShapeViewState{
    public IsResizing(ShapeViewContext shapeView) {
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
        int dw = dragEnd.x - shapeView.getDragStart().x;
        int dh = dragEnd.y - shapeView.getDragStart().y;

        shapeView.resizeShape(dw, dh);
        shapeView.setDragStart(dragEnd);
    }

}

package CanvasApp.View.ShapeView.ShapeViewState;

import CanvasApp.View.ShapeView.ConcreteShapeView;

import java.awt.event.MouseEvent;

public class IsReadyToSelect extends ShapeViewState {
    public IsReadyToSelect(ConcreteShapeView shapeView) {
        super(shapeView);
    }

    @Override
    public void onMousePressed(MouseEvent e) {
        if (!shapeView.isCorner(e.getPoint())) {
            if (e.isControlDown()) {
                shapeView.multiSelect(shapeView.getId());
            } else {
                shapeView.select(shapeView.getId());
            }
        }

        shapeView.setDragStart(e.getPoint());

        if (shapeView.isCorner(e.getPoint())) {
            shapeView.setCurrentState(new IsResizing(shapeView));
        } else {
            shapeView.setCurrentState(new IsMoving(shapeView));
        }
    }


    @Override
    public void onMouseReleased(MouseEvent e){}

    @Override
    public void onMouseDragged(MouseEvent e){}
}

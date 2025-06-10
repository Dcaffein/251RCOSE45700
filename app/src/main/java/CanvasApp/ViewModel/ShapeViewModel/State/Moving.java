package CanvasApp.ViewModel.ShapeViewModel.State;

import CanvasApp.ViewModel.ShapeViewModel.ShapeViewModel;

public class Moving implements MouseEventState {
    @Override
    public void onMousePressed(ShapeViewModel shapeViewModel, int x, int y, boolean ctrlDowned) {

    }

    @Override
    public void onMouseDragged(ShapeViewModel shapeViewModel, int x, int y) {
        int dx = x - shapeViewModel.getDragStartX();
        int dy = y - shapeViewModel.getDragStartY();
        shapeViewModel.moveBy(dx, dy);
        shapeViewModel.setDragStartPoint(x, y);
    }

    @Override
    public void onMouseReleased(ShapeViewModel shapeViewModel, int x, int y) {
        shapeViewModel.setMouseEventState(new ReadyToSelect());
    }
}

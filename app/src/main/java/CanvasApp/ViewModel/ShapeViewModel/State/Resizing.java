package CanvasApp.ViewModel.ShapeViewModel.State;

import CanvasApp.ViewModel.ShapeViewModel.ShapeViewModel;

public class Resizing implements MouseEventState {
    @Override
    public void onMousePressed(ShapeViewModel shapeViewModel, int x, int y, boolean ctrlDowned) {

    }

    @Override
    public void onMouseDragged(ShapeViewModel shapeViewModel, int x, int y) {
        int dw = x - shapeViewModel.getDragStartX();
        int dh = y - shapeViewModel.getDragStartY();
        shapeViewModel.resizeBy(dw, dh);
        shapeViewModel.setDragStartPoint(x, y);
    }

    @Override
    public void onMouseReleased(ShapeViewModel shapeViewModel, int x, int y) {

        shapeViewModel.setMouseEventState(new ReadyToSelect());
    }
}

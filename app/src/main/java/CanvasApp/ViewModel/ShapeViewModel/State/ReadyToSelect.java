package CanvasApp.ViewModel.ShapeViewModel.State;

import CanvasApp.ViewModel.ShapeViewModel.ShapeViewModel;

public class ReadyToSelect implements MouseEventState {
    @Override
    public void onMousePressed(ShapeViewModel shapeViewModel, int x, int y, boolean ctrlDowned) {
        if (!(shapeViewModel.isCorner(x, y))) {
            if (ctrlDowned) {
                shapeViewModel.multiSelectWithThis();
            } else {
                shapeViewModel.selectThis();
            }
        }

        shapeViewModel.setDragStartPoint(x,y);
        if (shapeViewModel.isCorner(x, y)) {
            shapeViewModel.setMouseEventState(new Resizing());
        } else {
            shapeViewModel.setMouseEventState(new Moving());
        }

    }

    @Override
    public void onMouseDragged(ShapeViewModel shapeViewModel, int x, int y) {

    }

    @Override
    public void onMouseReleased(ShapeViewModel shapeViewModel, int x, int y) {

    }
}

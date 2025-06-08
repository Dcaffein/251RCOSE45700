package CanvasApp.ViewModel.ShapeViewModel.State;

import CanvasApp.ViewModel.ShapeViewModel.ShapeViewModel;

public interface MouseEventState {
    void onMousePressed(ShapeViewModel shapeViewModel, int x, int y, boolean ctrlDowned);
    void onMouseDragged(ShapeViewModel shapeViewModel, int x, int y);
    void onMouseReleased(ShapeViewModel shapeViewModel, int x, int y);
}

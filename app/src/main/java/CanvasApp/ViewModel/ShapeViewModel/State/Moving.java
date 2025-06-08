package CanvasApp.ViewModel.ShapeViewModel.State;

import CanvasApp.ViewModel.SelectionManager.Cmd.MoveBy;
import CanvasApp.ViewModel.ShapeViewModel.ShapeViewModel;

public class Moving implements MouseEventState {
    @Override
    public void onMousePressed(ShapeViewModel shapeViewModel, int x, int y, boolean ctrlDowned) {

    }

    @Override
    public void onMouseDragged(ShapeViewModel shapeViewModel, int x, int y) {
        int dx = x - shapeViewModel.dragStartX;
        int dy = y - shapeViewModel.dragStartY;
        (new MoveBy(shapeViewModel.selectionManager,dx,dy)).execute();
        shapeViewModel.setDragStartPoint(x, y);
    }

    @Override
    public void onMouseReleased(ShapeViewModel shapeViewModel, int x, int y) {
        shapeViewModel.setMouseEventState(new ReadyToSelect());
    }
}

package CanvasApp.ViewModel.CanvasViewModel.State;

import CanvasApp.ViewModel.CanvasViewModel.CanvasViewModel;

public class ReadyToDrag implements CanvasViewModelState {
    @Override
    public void onMousePressed(CanvasViewModel canvasViewModel, int x, int y) {
        canvasViewModel.setDragStartPoint(x, y);
        canvasViewModel.setCurrentState(new IsDragging());
    }

    @Override
    public void onMouseReleased(CanvasViewModel canvasViewModel, int x, int y) {

    }
}

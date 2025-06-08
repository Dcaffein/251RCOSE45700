package CanvasApp.ViewModel.CanvasViewModel.State;

import CanvasApp.ViewModel.CanvasViewModel.CanvasViewModel;


public interface MouseEventState {
    void onMousePressed(CanvasViewModel canvasViewModel, int x, int y);
    void onMouseReleased(CanvasViewModel canvasViewModel, int x, int y);
}

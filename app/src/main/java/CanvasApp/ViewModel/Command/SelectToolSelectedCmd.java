package CanvasApp.ViewModel.Command;

import CanvasApp.ViewModel.CanvasVM;
import Command.Command;

public class SelectToolSelectedCmd implements Command {
    private final CanvasVM canvasVM;

    public SelectToolSelectedCmd(CanvasVM viewModel) {
        this.canvasVM = viewModel;
    }

    @Override
    public void execute() {
        canvasVM.setCanvasDraggable(false);
    }
}

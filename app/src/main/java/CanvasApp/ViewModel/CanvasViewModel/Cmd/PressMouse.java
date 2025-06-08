package CanvasApp.ViewModel.CanvasViewModel.Cmd;

import CanvasApp.ViewModel.CanvasViewModel.CanvasViewModel;
import Command.Command;

import java.awt.event.MouseEvent;

public class PressMouse implements Command {
    private final CanvasViewModel canvasViewModel;
    private final int x;
    private final int y;

    public PressMouse(CanvasViewModel canvasViewModel, MouseEvent mouseEvent) {
        this.canvasViewModel = canvasViewModel;
        this.x = mouseEvent.getX();
        this.y = mouseEvent.getY();
    }

    @Override
    public void execute() {
        canvasViewModel.currentState.onMousePressed(canvasViewModel, x, y);
    }
}

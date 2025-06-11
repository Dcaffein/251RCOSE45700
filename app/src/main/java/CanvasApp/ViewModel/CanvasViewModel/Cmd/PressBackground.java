package CanvasApp.ViewModel.CanvasViewModel.Cmd;

import CanvasApp.ViewModel.CanvasViewModel.CanvasViewModel;
import Command.Command;

import java.awt.event.MouseEvent;

public class PressBackground implements Command {
    private final CanvasViewModel canvasViewModel;

    public PressBackground(CanvasViewModel canvasViewModel) {
        this.canvasViewModel = canvasViewModel;
    }

    @Override
    public void execute() {
        canvasViewModel.deselectAllShapes();
    }
}
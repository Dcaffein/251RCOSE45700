package CanvasApp.ViewModel.CanvasViewModel.Cmd;

import CanvasApp.ViewModel.CanvasViewModel.CanvasViewModel;
import Command.Command;

import java.awt.event.MouseEvent;

public class ReleaseMouse implements Command {
    private final CanvasViewModel canvasViewModel;
    private final int x;
    private final int y;

    public ReleaseMouse(CanvasViewModel canvasViewModel, MouseEvent e) {
        this.canvasViewModel = canvasViewModel;
        this.x = e.getX();
        this.y = e.getY();
    }

    @Override
    public void execute() {
        System.out.println("[ReleaseMouse Command] ReleaseMouse");
        canvasViewModel.currentState.onMouseReleased(canvasViewModel,x,y);
    }
}

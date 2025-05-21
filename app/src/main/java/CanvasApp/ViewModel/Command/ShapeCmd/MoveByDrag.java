package CanvasApp.ViewModel.Command.ShapeCmd;

import CanvasApp.ViewModel.CanvasVM;
import Command.Command;

public class MoveByDrag implements Command {
    private final CanvasVM canvasVM;
    private final int dx,dy;

    public MoveByDrag(CanvasVM canvasVM, int dx, int dy) {
        this.canvasVM = canvasVM;
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public void execute() {
        canvasVM.moveByDrag(dx,dy);
    }
}

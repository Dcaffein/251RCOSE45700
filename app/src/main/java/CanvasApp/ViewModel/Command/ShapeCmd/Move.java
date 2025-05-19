package CanvasApp.ViewModel.Command.ShapeCmd;

import CanvasApp.ViewModel.CanvasVM;
import Command.Command;

public class Move implements Command {
    public CanvasVM canvasVM;
    int newX, newY;

    public Move(CanvasVM canvasVM,int newX,int newY) {
        this.canvasVM = canvasVM;
        this.newX = newX;
        this.newY = newY;
    }

    @Override
    public void execute() {
        canvasVM.selected.move(newX, newY);
    }
}

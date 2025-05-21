package CanvasApp.ViewModel.Command.ShapeCmd;

import CanvasApp.ViewModel.CanvasVM;
import Command.Command;

public class MoveTo implements Command {
    public CanvasVM canvasVM;
    int newX, newY;

    public MoveTo(CanvasVM canvasVM, int newX, int newY) {
        this.canvasVM = canvasVM;
        this.newX = newX;
        this.newY = newY;
    }

    @Override
    public void execute() {
        System.out.println("[MoveTo] newX : " + newX + ", newY :" + newY);
        canvasVM.moveTo(newX, newY);
    }
}

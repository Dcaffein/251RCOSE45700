package CanvasApp.ViewModel.Command.ShapeCmd;

import CanvasApp.ViewModel.CanvasVM;
import Command.Command;

public class Resize implements Command {
    CanvasVM canvasVM;
    int newW,newH;

    public Resize(CanvasVM canvasVM, int newW, int newH) {
        this.canvasVM = canvasVM;
        this.newW = newW;
        this.newH = newH;
    }

    @Override
    public void execute() {
        canvasVM.selected.resize(newW,newH);
    }
}

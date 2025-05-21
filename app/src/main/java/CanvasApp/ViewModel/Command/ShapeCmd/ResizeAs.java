package CanvasApp.ViewModel.Command.ShapeCmd;

import CanvasApp.ViewModel.CanvasVM;
import Command.Command;

public class ResizeAs implements Command {
    CanvasVM canvasVM;
    int newW,newH;

    public ResizeAs(CanvasVM canvasVM, int newW, int newH) {
        this.canvasVM = canvasVM;
        this.newW = newW;
        this.newH = newH;
    }

    @Override
    public void execute() {
        canvasVM.resizeAs(newW,newH);
    }
}

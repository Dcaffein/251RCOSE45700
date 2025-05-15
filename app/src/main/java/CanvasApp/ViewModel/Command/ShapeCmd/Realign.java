package CanvasApp.ViewModel.Command.ShapeCmd;

import CanvasApp.ViewModel.CanvasVM;
import Command.Command;

public class Realign implements Command {
    public CanvasVM canvasVM;
    public int z;

    public Realign(CanvasVM canvasVM, int z) {
        this.canvasVM = canvasVM;
        this.z = z;
    }

    @Override
    public void execute() {
        canvasVM.selected.realign(z);
    }
}

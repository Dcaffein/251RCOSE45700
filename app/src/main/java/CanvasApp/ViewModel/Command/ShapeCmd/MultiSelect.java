package CanvasApp.ViewModel.Command.ShapeCmd;

import CanvasApp.ViewModel.CanvasVM;
import Command.Command;

public class MultiSelect implements Command {
    public String id;
    public CanvasVM canvasVM;

    public MultiSelect(String id, CanvasVM canvasVM) {
        this.id = id;
        this.canvasVM = canvasVM;
    }

    @Override
    public void execute() {
        canvasVM.toggleSelect(id);
    }
}

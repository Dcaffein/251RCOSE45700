package CanvasApp.ViewModel.Command.ShapeCmd;

import CanvasApp.ViewModel.CanvasVM;
import Command.Command;

public class Select implements Command {
    public String id;
    public CanvasVM canvasVM;

    public Select(String id, CanvasVM canvasVM) {
        this.id = id;
        this.canvasVM = canvasVM;
    }

    @Override
    public void execute() {
        canvasVM.deSelectAll();
        canvasVM.toggleSelect(id);
    }
}

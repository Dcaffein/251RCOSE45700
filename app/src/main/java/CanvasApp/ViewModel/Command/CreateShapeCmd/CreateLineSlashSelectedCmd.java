package CanvasApp.ViewModel.Command.CreateShapeCmd;

import CanvasApp.Factory.LineSlashFactory;
import CanvasApp.ViewModel.CanvasVM;
import Command.Command;

public class CreateLineSlashSelectedCmd implements Command {
    CanvasVM canvasVM;

    public CreateLineSlashSelectedCmd(CanvasVM canvasVM) {
        this.canvasVM = canvasVM;
    }

    public void execute() {
        System.out.println("[ToolCmd] CreateLineSlashSelectedCmd executed");
        canvasVM.deSelectAll();
        canvasVM.setCurrentFactory(LineSlashFactory.getInstance());
        canvasVM.setCanvasDraggable(true);
    }
}

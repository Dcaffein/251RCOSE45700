package CanvasApp.ViewModel.Command.CreateShapeCmd;

import CanvasApp.Factory.LineBackSlashFactory;
import CanvasApp.ViewModel.CanvasVM;
import Command.Command;

public class CreateLineBackSlashSelectedCmd implements Command {
    CanvasVM canvasVM;

    public CreateLineBackSlashSelectedCmd(CanvasVM canvasVM) {
        this.canvasVM = canvasVM;
    }

    public void execute() {
        System.out.println("[ToolCmd] CreateLineBackSlashSelectedCmd executed");
        canvasVM.deSelectAll();
        canvasVM.setCurrentFactory(LineBackSlashFactory.getInstance());
        canvasVM.setCanvasDraggable(true);
    }
}

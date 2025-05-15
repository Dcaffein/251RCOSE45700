package CanvasApp.ViewModel.Command.CreateShapeCmd;

import CanvasApp.Factory.RectFactory;
import CanvasApp.ViewModel.CanvasVM;
import Command.Command;

public class CreateRectSelectedCmd implements Command {
    CanvasVM canvasVM;
    public CreateRectSelectedCmd(CanvasVM canvasVM) {
        this.canvasVM = canvasVM;
    }

    public void execute() {
        System.out.println("[ToolCmd] CreateRectSelectedCmd executed");
        canvasVM.setCurrentFactory(RectFactory.getInstance());
        canvasVM.setCanvasDraggable(true);
    }
}

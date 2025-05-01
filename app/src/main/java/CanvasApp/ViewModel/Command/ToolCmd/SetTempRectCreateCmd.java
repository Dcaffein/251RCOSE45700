package CanvasApp.ViewModel.Command.ToolCmd;

import CanvasApp.Model.Canvas.Cmd.CreateRectModelCmd;
import CanvasApp.ViewModel.CanvasVM;
import Command.Command;

public class SetTempRectCreateCmd implements Command {
    CanvasVM canvasVM;
    public SetTempRectCreateCmd(CanvasVM canvasVM) {
        this.canvasVM = canvasVM;
    }

    public void execute() {
        System.out.println("[ToolCmd] SetTempRectCreateCmd executed");
        canvasVM.setTempCreateCmd(new CreateRectModelCmd());
        canvasVM.setCanvasDraggable(true);
    }
}

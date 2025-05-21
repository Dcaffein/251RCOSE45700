package CanvasApp.ViewModel.Command.CreateShapeCmd;

import CanvasApp.Factory.RectFactory;
import CanvasApp.Factory.TextFactory;
import CanvasApp.ViewModel.CanvasVM;
import Command.Command;

public class CreateTextSelectedCmd implements Command {
    CanvasVM canvasVM;

    public CreateTextSelectedCmd(CanvasVM canvasVM) {
        this.canvasVM = canvasVM;
    }

    @Override
    public void execute() {
        canvasVM.deSelectAll();
        canvasVM.setCurrentFactory(TextFactory.getInstance());
        canvasVM.setCanvasDraggable(true);
    }
}

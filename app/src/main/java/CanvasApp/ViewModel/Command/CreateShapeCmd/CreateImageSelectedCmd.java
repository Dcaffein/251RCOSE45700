package CanvasApp.ViewModel.Command.CreateShapeCmd;

import CanvasApp.Factory.ImageFactory;
import CanvasApp.ViewModel.CanvasVM;
import Command.Command;

public class CreateImageSelectedCmd implements Command {
    CanvasVM canvasVM;

    public CreateImageSelectedCmd(CanvasVM canvasVM) {
        this.canvasVM = canvasVM;
    }

    @Override
    public void execute() {
        canvasVM.deSelectAll();
        canvasVM.setCurrentFactory(ImageFactory.getInstance());
        canvasVM.setCanvasDraggable(true);
    }
}

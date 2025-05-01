package CanvasApp.ViewModel.Command;

import CanvasApp.ViewModel.CanvasVM;
import Command.Command;

public class CreateShapeCmd implements Command {
    public CanvasVM canvasVM;
    public int x,y,w,h,z;

    public CreateShapeCmd(CanvasVM canvasVM, int x, int y, int w, int h, int z) {
        this.canvasVM = canvasVM;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.z = z;
    }

    @Override
    public void execute() {
        canvasVM.completeTempCreateCmd(x,y,w,h,z);
        canvasVM.setCanvasDraggable(false);
    }
}

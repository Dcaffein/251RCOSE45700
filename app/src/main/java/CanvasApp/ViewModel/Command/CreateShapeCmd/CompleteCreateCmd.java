package CanvasApp.ViewModel.Command.CreateShapeCmd;

import CanvasApp.ViewModel.CanvasVM;
import Command.Command;

public class CompleteCreateCmd implements Command {
    public CanvasVM canvasVM;
    public int x,y,w,h,z;

    public CompleteCreateCmd(CanvasVM canvasVM, int x, int y, int w, int h, int z) {
        this.canvasVM = canvasVM;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.z = z;
    }

    @Override
    public void execute() {
        canvasVM.createShapeLeafByDrag(x,y,w,h,z);
        canvasVM.setCanvasDraggable(false);
    }
}

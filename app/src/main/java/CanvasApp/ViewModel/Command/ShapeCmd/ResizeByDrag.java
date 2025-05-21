package CanvasApp.ViewModel.Command.ShapeCmd;

import CanvasApp.ViewModel.CanvasVM;
import Command.Command;

public class ResizeByDrag implements Command {
    private final CanvasVM canvasVM;
    private final int dw,dh;

    public ResizeByDrag(CanvasVM canvasVM, int dw, int dh) {
        this.canvasVM = canvasVM;
        this.dw = dw;
        this.dh = dh;
    }

    @Override
    public void execute() {
        System.out.println("[concreteShapeView resizeShape]. dw : " + dw + ", dh :" + dh);
        canvasVM.resizeByDrag(dw,dh);
    }
}

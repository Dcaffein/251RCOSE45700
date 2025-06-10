package CanvasApp.Model.Cmd;

import CanvasApp.Model.ShapeModel;

import Command.Command;

public class ResizeBy implements Command{
    private final ShapeModel selected;
    private final int dw,dh;

    public ResizeBy(ShapeModel selected, int dw, int dh){
        this.selected = selected;
        this.dw = dw;
        this.dh = dh;
    }

    @Override
    public void execute() {
        selected.resizeBy(dw, dh);
    }
}

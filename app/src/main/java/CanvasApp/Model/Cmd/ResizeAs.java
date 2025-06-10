package CanvasApp.Model.Cmd;

import CanvasApp.Model.ShapeModel;
import Command.Command;

public class ResizeAs implements Command {
    private final ShapeModel selected;
    private final int newW,newH;

    public ResizeAs(ShapeModel selected, int newW, int newH){
        this.selected = selected;
        this.newW = newW;
        this.newH = newH;
    }

    @Override
    public void execute() {
        selected.resizeAs(newW, newH);
    }
}

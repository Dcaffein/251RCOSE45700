package CanvasApp.Model.Cmd;

import CanvasApp.Model.ShapeModel;
import Command.Command;

public class SetSize implements Command {
    private final ShapeModel selected;
    private final int newW,newH;

    public SetSize(ShapeModel selected, int newW, int newH){
        this.selected = selected;
        this.newW = newW;
        this.newH = newH;
    }

    @Override
    public void execute() {
        selected.setSize(newW, newH);
    }
}

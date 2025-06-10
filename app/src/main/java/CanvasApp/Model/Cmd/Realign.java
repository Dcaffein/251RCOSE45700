package CanvasApp.Model.Cmd;

import CanvasApp.Model.ShapeModel;
import Command.Command;

public class Realign implements Command {
    private final ShapeModel selected;
    private final int newZ;

    public Realign(ShapeModel selected, int newZ ){
        this.selected = selected;
        this.newZ = newZ;
    }

    @Override
    public void execute() {
        selected.realign(newZ);
    }
}
package CanvasApp.Model.Cmd;

import CanvasApp.Model.ShapeModel;
import Command.Command;

public class MoveTo implements Command {
    private final ShapeModel selected;
    private final int newX,newY;

    public MoveTo(ShapeModel selected, int newX, int newY){
        this.selected = selected;
        this.newX = newX;
        this.newY = newY;
    }

    @Override
    public void execute() {
        selected.moveTo(newX, newY);
    }
}

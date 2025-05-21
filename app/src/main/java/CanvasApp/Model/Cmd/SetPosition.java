package CanvasApp.Model.Cmd;

import CanvasApp.Model.ShapeModel;
import Command.Command;

public class SetPosition implements Command {
    private final ShapeModel selected;
    private final int newX,newY;

    public SetPosition(ShapeModel selected, int newX, int newY){
        this.selected = selected;
        this.newX = newX;
        this.newY = newY;
    }

    @Override
    public void execute() {
        selected.setPosition(newX, newY);
    }
}

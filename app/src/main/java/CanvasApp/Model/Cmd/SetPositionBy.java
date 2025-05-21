package CanvasApp.Model.Cmd;

import CanvasApp.Model.ShapeModel;
import Command.Command;

public class SetPositionBy implements Command {
    private final ShapeModel selected;
    private final int dx,dy;

    public SetPositionBy(ShapeModel selected, int dx, int dy){
        this.selected = selected;
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public void execute() {
        selected.setPositionBy(dx, dy);
    }
}

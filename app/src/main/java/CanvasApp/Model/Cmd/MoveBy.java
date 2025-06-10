package CanvasApp.Model.Cmd;

import CanvasApp.Model.ShapeModel;
import Command.Command;

public class MoveBy implements Command {
    private final ShapeModel selected;
    private final int dx,dy;

    public MoveBy(ShapeModel selected, int dx, int dy){
        this.selected = selected;
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public void execute() {
        selected.moveBy(dx, dy);
    }
}

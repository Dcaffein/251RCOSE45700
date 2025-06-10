package CanvasApp.Model.Cmd;

import CanvasApp.Model.ShapeModel;
import Command.Command;

public class Replace implements Command {
    private final ShapeModel canvas;
    private final ShapeModel oldOne;
    private final ShapeModel newOne;

    public Replace(ShapeModel canvas, ShapeModel oldOne, ShapeModel newOne) {
        this.canvas = canvas;
        this.oldOne = oldOne;
        this.newOne = newOne;
    }

    @Override
    public void execute() {
        canvas.replace(oldOne,newOne);
    }
}

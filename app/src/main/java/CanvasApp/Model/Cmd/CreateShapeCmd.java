package CanvasApp.Model.Cmd;

import CanvasApp.Model.ShapeModel;
import Command.Command;

public class CreateShapeCmd implements Command {
    private final ShapeModel canvas;
    private final ShapeModel shape;

    public CreateShapeCmd(ShapeModel canvas, ShapeModel shape) {
        this.canvas = canvas;
        this.shape = shape;
    }

    @Override
    public void execute() {
        canvas.addChild(shape);
    }
}

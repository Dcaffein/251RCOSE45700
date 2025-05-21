package CanvasApp.Model.Cmd;

import CanvasApp.Factory.ShapeFactory;
import CanvasApp.Model.ShapeModel;
import Command.Command;

public class CreateShapeCmd implements Command {
    private final ShapeFactory shapeFactory;
    private int x, y, w, h, z;
    private final ShapeModel canvas;

    public CreateShapeCmd(ShapeModel canvas, ShapeFactory shapeFactory, int x, int y, int w, int h, int z) {
        this.canvas = canvas;
        this.shapeFactory = shapeFactory;
        this.x = x; this.y = y; this.w = w; this.h = h; this.z = z;
    }

    @Override
    public void execute() {
        ShapeModel shapeModel = shapeFactory.createShapeModel(x, y, w, h, z);
        canvas.add(shapeModel);
        System.out.println("[CreateRectModelCmd] fired ShapeAdded event for id=" + shapeModel.getId());
    }
}

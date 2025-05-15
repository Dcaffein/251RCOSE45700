package CanvasApp.Model.Shape.Cmd;

import CanvasApp.Factory.ShapeFactory;
import CanvasApp.Model.Shape.Composite.Leaf.ShapeModelLeaf;
import CanvasApp.Model.Shape.ShapeModel;
import Command.Command;

public class CreateShapeLeafCmd implements Command {
    private final ShapeFactory shapeFactory;
    private int x, y, w, h, z;
    private ShapeModel canvas;

    public CreateShapeLeafCmd(ShapeModel canvas, ShapeFactory shapeFactory, int x, int y, int w, int h, int z) {
        this.canvas = canvas;
        this.shapeFactory = shapeFactory;
        this.x = x; this.y = y; this.w = w; this.h = h; this.z = z;
    }

    @Override
    public void execute() {
        ShapeModelLeaf shapeModelLeaf = shapeFactory.createShapeModel(x, y, w, h, z);
        canvas.add(shapeModelLeaf);
        System.out.println("[CreateRectModelCmd] fired ShapeAdded event for id=" + shapeModelLeaf.getId());
    }
}

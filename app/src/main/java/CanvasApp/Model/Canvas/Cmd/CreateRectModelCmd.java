package CanvasApp.Model.Canvas.Cmd;

import CanvasApp.Model.Canvas.CanvasModel;
import CanvasApp.Model.Canvas.Observer.ConcreteShapeAdded.RectAddedShapeAdded;
import CanvasApp.Model.Factory.RectFactory;
import CanvasApp.Model.Shape.ShapeModel;

public class CreateRectModelCmd implements CreateShapeModelCmd {
    private final RectFactory factory = RectFactory.getInstance();
    private int x, y, w, h, z;
    private  CanvasModel canvasModel;

    public CreateRectModelCmd() {}

    public CreateRectModelCmd(CanvasModel canvasModel,int x, int y, int w, int h, int z) {
        this.canvasModel = canvasModel;
        this.x = x; this.y = y; this.w = w; this.h = h; this.z = z;
    }

    @Override
    public void execute() {
        if(canvasModel==null){
            return;
        }
        ShapeModel shapeModel = factory.createShapeModel(x, y, w, h, z);
        canvasModel.addShape(shapeModel);
        canvasModel.notify(new RectAddedShapeAdded(shapeModel.getId()));
    }

    @Override
    public void Complete(CanvasModel canvasModel,int x, int y, int w, int h, int z) {
        this.canvasModel = canvasModel;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.z = z;
    }
}

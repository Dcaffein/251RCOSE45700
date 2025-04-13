package Canvas.Domain.Command.ShapeCommand.CreateShape;

import Canvas.Domain.ShapeObject.ShapeObject;
import Canvas.Domain.Factory.ShapeFactory.RectFactory;
import Canvas.ViewModel.CanvasVM;

import java.util.UUID;

public class CreateRectCommand implements CreateShapeCommand {
    private final String id;
    private final CanvasVM viewModel;
    private final int x;
    private final int y;
    private final int w;
    private final int h;
    private final int z;

    public CreateRectCommand(CanvasVM viewModel,int x,int y,int w, int h, int z) {
        this.id = UUID.randomUUID().toString();
        this.viewModel = viewModel;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.z = z;
    }

    @Override
    public String execute() {
        RectFactory factory = RectFactory.getInstance();

        ShapeObject shape = factory.create(id, x, y, w, h, z);
        viewModel.addShape(id, shape);
        shape.attach(viewModel);
        return id;
    }
}
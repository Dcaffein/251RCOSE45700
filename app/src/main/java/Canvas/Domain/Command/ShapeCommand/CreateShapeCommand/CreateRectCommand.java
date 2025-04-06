package Canvas.Domain.Command.ShapeCommand.CreateShapeCommand;

import Canvas.Domain.ShapeObject.ShapeObject;
import Canvas.Domain.Factory.ShapeFactory.RectFactory;
import Canvas.ViewModel.CanvasVM;

import java.util.UUID;

public class CreateRectCommand implements CreateShapeCommand {
    private final String id;
    private final CanvasVM viewModel;

    public CreateRectCommand(CanvasVM viewModel) {
        this.id = UUID.randomUUID().toString();
        this.viewModel = viewModel;
    }

    @Override
    public String execute() {
        RectFactory factory = RectFactory.getInstance();
        ShapeObject shape = factory.create(id, 50, 50, 100, 100, 0);
        viewModel.addShape(id, shape);
        shape.attach(viewModel);
        return id;
    }
}
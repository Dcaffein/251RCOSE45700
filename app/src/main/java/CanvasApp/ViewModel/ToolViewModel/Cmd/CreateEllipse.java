package CanvasApp.ViewModel.ToolViewModel.Cmd;

import CanvasApp.Factory.Shape.EllipseFactory;
import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.ToolViewModel.ToolViewModel;
import Command.Command;

public class CreateEllipse implements Command {
    private final ToolViewModel toolViewModel;

    public CreateEllipse(ToolViewModel toolViewModel) {
        this.toolViewModel = toolViewModel;
    }

    @Override
    public void execute() {
        ShapeModel ellipse = EllipseFactory.getInstance().createShapeModel(0,0,0,0,0);
        toolViewModel.readyToAdd(ellipse);
    }
}

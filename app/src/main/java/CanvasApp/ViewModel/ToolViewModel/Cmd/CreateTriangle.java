package CanvasApp.ViewModel.ToolViewModel.Cmd;

import CanvasApp.Factory.Shape.TriangleFactory;
import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.ToolViewModel.ToolViewModel;
import Command.Command;

public class CreateTriangle implements Command {
    private final ToolViewModel toolViewModel;

    public CreateTriangle(ToolViewModel toolViewModel) {
        this.toolViewModel = toolViewModel;
    }

    @Override
    public void execute() {
        ShapeModel ellipse = TriangleFactory.getInstance().createShapeModel(0,0,0,0,0);
        toolViewModel.readyToAdd(ellipse);
    }
}

package CanvasApp.ViewModel.ToolViewModel.Cmd;

import CanvasApp.Factory.Shape.RectFactory;
import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.ToolViewModel.ToolViewModel;
import Command.Command;

public class CreateRect implements Command {
    private final ToolViewModel toolViewModel;

    public CreateRect(ToolViewModel toolViewModel) {
        this.toolViewModel = toolViewModel;
    }

    @Override
    public void execute() {
        ShapeModel ellipse = RectFactory.getInstance().createShapeModel(0,0,0,0,0);
        toolViewModel.readyToAdd(ellipse);
    }
}

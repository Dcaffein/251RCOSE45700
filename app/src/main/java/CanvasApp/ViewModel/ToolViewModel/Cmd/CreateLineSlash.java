package CanvasApp.ViewModel.ToolViewModel.Cmd;

import CanvasApp.Factory.Shape.LineSlashFactory;
import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.ToolViewModel.ToolViewModel;
import Command.Command;

public class CreateLineSlash implements Command {
    private final ToolViewModel toolViewModel;

    public CreateLineSlash(ToolViewModel toolViewModel) {
        this.toolViewModel = toolViewModel;
    }

    @Override
    public void execute() {
        ShapeModel ellipse = LineSlashFactory.getInstance().createShapeModel(0,0,0,0,0);
        toolViewModel.readyToAdd(ellipse);
    }
}

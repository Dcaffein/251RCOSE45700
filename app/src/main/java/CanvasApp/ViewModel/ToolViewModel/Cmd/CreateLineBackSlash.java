package CanvasApp.ViewModel.ToolViewModel.Cmd;

import CanvasApp.Factory.Shape.LineBackSlashFactory;
import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.ToolViewModel.ToolViewModel;
import Command.Command;

public class CreateLineBackSlash implements Command {
    private final ToolViewModel toolViewModel;

    public CreateLineBackSlash(ToolViewModel toolViewModel) {
        this.toolViewModel = toolViewModel;
    }

    @Override
    public void execute() {
        ShapeModel ellipse = LineBackSlashFactory.getInstance().createShapeModel(0,0,0,0,0);
        toolViewModel.readyToAdd(ellipse);
    }
}

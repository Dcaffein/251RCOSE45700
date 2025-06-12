package CanvasApp.ViewModel.ToolViewModel.Cmd;

import CanvasApp.Factory.Shape.RectFactory;
import CanvasApp.Factory.Shape.TextFactory;
import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.ToolViewModel.ToolViewModel;
import Command.Command;

public class CreateText implements Command {
    private final ToolViewModel toolViewModel;

    public CreateText(ToolViewModel toolViewModel) {
        this.toolViewModel = toolViewModel;
    }

    @Override
    public void execute() {
        ShapeModel text = TextFactory.getInstance().createShapeModel(0,0,0,0,0);
        toolViewModel.readyToAdd(text);
    }
}

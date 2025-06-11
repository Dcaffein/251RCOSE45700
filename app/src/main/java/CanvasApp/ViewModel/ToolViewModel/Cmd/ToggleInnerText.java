package CanvasApp.ViewModel.ToolViewModel.Cmd;

import CanvasApp.Factory.Shape.Decorator.InnerTextFactory;
import CanvasApp.Model.Decorator.InnerText;
import CanvasApp.Model.Decorator.ShapeDecorator;
import CanvasApp.ViewModel.ToolViewModel.ToolViewModel;
import Command.Command;

public class ToggleInnerText implements Command {
    private final ToolViewModel viewModel;

    public ToggleInnerText(ToolViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void execute() {
        viewModel.getSelectedShapes().forEach(shape -> {
            if(!(viewModel.undoExistingDeco(shape, InnerText.class))){
                ShapeDecorator innerText = InnerTextFactory.getInstance().createDecorator(shape);
                viewModel.applyDeco(innerText);
            }
        });
    }
}

package CanvasApp.ViewModel.ToolViewModel.Cmd;

import CanvasApp.Factory.Shape.Decorator.InnerTextFactory;
import CanvasApp.Model.Decorator.ShapeDecorator;
import CanvasApp.ViewModel.ToolViewModel.ToolViewModel;
import Command.Command;

public class ApplyInnerText implements Command {
    private final ToolViewModel viewModel;

    public ApplyInnerText(ToolViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void execute() {
        viewModel.getSelectedShapes().forEach(shape -> {
            ShapeDecorator innerText = InnerTextFactory.getInstance().createDecorator(shape);
            viewModel.decorate(innerText);
        });
    }
}

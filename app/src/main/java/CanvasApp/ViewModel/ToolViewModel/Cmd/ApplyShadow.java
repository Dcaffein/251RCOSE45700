package CanvasApp.ViewModel.ToolViewModel.Cmd;

import CanvasApp.Factory.Shape.Decorator.ShadowFactory;
import CanvasApp.Model.Decorator.ShapeDecorator;
import CanvasApp.ViewModel.ToolViewModel.ToolViewModel;
import Command.Command;

public class ApplyShadow implements Command {
    private final ToolViewModel viewModel;

    public ApplyShadow(ToolViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void execute() {
        viewModel.getSelectedShapes().forEach(shape -> {
            ShapeDecorator shadow = ShadowFactory.getInstance().createDecorator(shape);
            viewModel.decorate(shadow);
        });
    }
}

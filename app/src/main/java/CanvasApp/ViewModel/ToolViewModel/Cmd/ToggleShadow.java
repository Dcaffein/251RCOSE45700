package CanvasApp.ViewModel.ToolViewModel.Cmd;

import CanvasApp.Factory.Shape.Decorator.ShadowFactory;
import CanvasApp.Model.Decorator.Shadow;
import CanvasApp.Model.Decorator.ShapeDecorator;
import CanvasApp.ViewModel.ToolViewModel.ToolViewModel;
import Command.Command;

public class ToggleShadow implements Command {
    private final ToolViewModel viewModel;

    public ToggleShadow(ToolViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void execute() {
        viewModel.getSelectedShapes().forEach(shape -> {
            System.out.println("[getSelectedShapes] getSelectedShape: " + shape);
            if(!(viewModel.undoExistingDeco(shape, Shadow.class))){
                ShapeDecorator shadow = ShadowFactory.getInstance().createDecorator(shape);
                viewModel.applyDeco(shadow);
            }
        });
    }
}

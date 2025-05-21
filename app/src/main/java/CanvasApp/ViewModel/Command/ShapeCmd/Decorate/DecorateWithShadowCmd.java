package CanvasApp.ViewModel.Command.ShapeCmd.Decorate;

import CanvasApp.ViewModel.CanvasVM;
import Command.Command;

import java.awt.*;

public class DecorateWithShadowCmd implements Command {
    private final CanvasVM viewModel;
    private final Color color;
    private final int border;

    public DecorateWithShadowCmd(CanvasVM viewModel,Color color ,int border) {
        this.viewModel = viewModel;
        this.color = color;
        this.border = border;
    }

    @Override
    public void execute() {
        viewModel.decoratesWithShadow(color,border);
    }
}

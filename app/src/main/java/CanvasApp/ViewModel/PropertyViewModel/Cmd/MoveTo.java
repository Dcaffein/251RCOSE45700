package CanvasApp.ViewModel.PropertyViewModel.Cmd;

import CanvasApp.ViewModel.PropertyViewModel.PropertyViewModel;
import Command.Command;

public class MoveTo implements Command {
    private final PropertyViewModel viewModel;
    private final int newX,newY;

    public MoveTo(PropertyViewModel viewModel, int newX, int newY) {
        this.viewModel = viewModel;
        this.newX = newX;
        this.newY = newY;
    }

    @Override
    public void execute() {
        viewModel.moveTo(newX, newY);
    }
}

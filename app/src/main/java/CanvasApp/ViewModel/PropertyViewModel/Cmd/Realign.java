package CanvasApp.ViewModel.PropertyViewModel.Cmd;

import CanvasApp.ViewModel.PropertyViewModel.PropertyViewModel;
import Command.Command;

public class Realign implements Command {
    private final PropertyViewModel viewModel;
    private final int newZ;

    public Realign(PropertyViewModel viewModel, int newZ) {
        this.viewModel = viewModel;
        this.newZ = newZ;
    }

    @Override
    public void execute() {
        viewModel.realign(newZ);
    }
}
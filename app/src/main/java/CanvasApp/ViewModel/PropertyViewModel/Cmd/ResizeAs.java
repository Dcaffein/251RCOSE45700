package CanvasApp.ViewModel.PropertyViewModel.Cmd;

import CanvasApp.ViewModel.PropertyViewModel.PropertyViewModel;
import Command.Command;

public class ResizeAs implements Command {
    private final PropertyViewModel viewModel;
    private final int newW,newH;

    public ResizeAs(PropertyViewModel viewModel, int newW, int newH) {
        this.viewModel = viewModel;
        this.newW = newW;
        this.newH = newH;
    }

    @Override
    public void execute() {
        viewModel.resizeAs(newW, newH);
    }
}
package CanvasApp.ViewModel.ToolViewModel.Cmd;

import CanvasApp.ViewModel.ToolViewModel.ToolViewModel;
import Command.Command;

public class ReadyToSelect implements Command {
    private final ToolViewModel toolViewModel;

    public ReadyToSelect(ToolViewModel toolViewModel) {
        this.toolViewModel = toolViewModel;
    }


    @Override
    public void execute() {
        toolViewModel.readyToSelect();
    }
}

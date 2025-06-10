package CanvasApp.ViewModel.SelectionManager.Cmd;

import CanvasApp.ViewModel.SelectionManager.SelectionManager;
import Command.Command;

public class UnselectAll implements Command {
    private final SelectionManager selectionManager;

    public UnselectAll(SelectionManager selectionManager) {
        this.selectionManager = selectionManager;
    }

    @Override
    public void execute() {
        selectionManager.unselectAll();
    }
}
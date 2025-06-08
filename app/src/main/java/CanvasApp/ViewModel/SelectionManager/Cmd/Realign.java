package CanvasApp.ViewModel.SelectionManager.Cmd;

import CanvasApp.ViewModel.SelectionManager.SelectionManager;
import Command.Command;

public class Realign implements Command {
    private final SelectionManager selectionManager;
    private final int newZ;

    public Realign(SelectionManager selectionManager, int newZ) {
        this.selectionManager = selectionManager;
        this.newZ = newZ;
    }

    @Override
    public void execute() {
        selectionManager.realign(newZ);
    }
}

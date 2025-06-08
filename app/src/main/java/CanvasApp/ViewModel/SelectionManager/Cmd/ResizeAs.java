package CanvasApp.ViewModel.SelectionManager.Cmd;

import CanvasApp.ViewModel.SelectionManager.SelectionManager;
import Command.Command;

public class ResizeAs implements Command {
    private final SelectionManager selectionManager;
    private final int newW;
    private final int newH;

    public ResizeAs(SelectionManager selectionManager, int newW, int newH) {
        this.selectionManager = selectionManager;
        this.newW = newW;
        this.newH = newH;
    }

    @Override
    public void execute() {
        selectionManager.setSize(newW, newH);
    }
}
package CanvasApp.ViewModel.SelectionManager.Cmd;

import CanvasApp.ViewModel.SelectionManager.SelectionManager;
import Command.Command;

public class MoveTo implements Command {
    private final SelectionManager selectionManager;
    private final int newX;
    private final int newY;

    public MoveTo(SelectionManager selectionManager,int newX, int newY) {
        this.selectionManager = selectionManager;
        this.newX = newX;
        this.newY = newY;
    }

    @Override
    public void execute() {
        selectionManager.setPosition(newX, newY);
    }
}
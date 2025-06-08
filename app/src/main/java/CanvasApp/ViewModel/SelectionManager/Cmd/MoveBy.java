package CanvasApp.ViewModel.SelectionManager.Cmd;

import CanvasApp.ViewModel.SelectionManager.SelectionManager;
import Command.Command;

public class MoveBy implements Command {
    private final SelectionManager selectionManager;
    private final int dx;
    private final int dy;

    public MoveBy(SelectionManager selectionManager,int dx, int dy) {
        this.selectionManager = selectionManager;
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public void execute() {
        selectionManager.setPositionBy(dx, dy);
    }
}
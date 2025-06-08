package CanvasApp.ViewModel.SelectionManager.Cmd;

import CanvasApp.ViewModel.SelectionManager.SelectionManager;
import Command.Command;

public class ResizeBy implements Command {
    private final SelectionManager selectionManager;
    private final int dw;
    private final int dh;

    public ResizeBy(SelectionManager selectionManager,int dw, int dh) {
        this.selectionManager = selectionManager;
        this.dw = dw;
        this.dh = dh;
    }

    @Override
    public void execute() {
        selectionManager.setSizeBy(dw,dh);
    }
}
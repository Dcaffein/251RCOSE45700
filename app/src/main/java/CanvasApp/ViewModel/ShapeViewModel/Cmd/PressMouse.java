package CanvasApp.ViewModel.ShapeViewModel.Cmd;

import CanvasApp.ViewModel.ShapeViewModel.ShapeViewModel;
import Command.Command;

import java.awt.event.MouseEvent;

public class PressMouse implements Command {
    private final ShapeViewModel shapeViewModel;
    private final int x;
    private final int y;
    private final boolean isCtrlDown;

    public PressMouse(ShapeViewModel shapeViewModel, MouseEvent mouseEvent) {
        this.shapeViewModel = shapeViewModel;
        this.x = mouseEvent.getX();
        this.y = mouseEvent.getY();
        this.isCtrlDown = mouseEvent.isControlDown();
    }

    @Override
    public void execute() {
        shapeViewModel.pressMouse(x, y,isCtrlDown);
    }
}

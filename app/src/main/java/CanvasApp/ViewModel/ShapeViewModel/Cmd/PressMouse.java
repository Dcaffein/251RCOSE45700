package CanvasApp.ViewModel.ShapeViewModel.Cmd;

import CanvasApp.ViewModel.ShapeViewModel.ShapeViewModel;
import Command.Command;

import java.awt.event.MouseEvent;

public class PressMouse implements Command {
    private final ShapeViewModel shapeViewModel;
    private final int x;
    private final int y;
    private final boolean ctrlDowned;

    public PressMouse(ShapeViewModel shapeViewModel, MouseEvent mouseEvent) {
        this.shapeViewModel = shapeViewModel;
        this.x = mouseEvent.getX();
        this.y = mouseEvent.getY();
        this.ctrlDowned = mouseEvent.isControlDown();
    }

    @Override
    public void execute() {
        shapeViewModel.mouseEventState.onMousePressed(shapeViewModel, x, y, ctrlDowned);
    }
}

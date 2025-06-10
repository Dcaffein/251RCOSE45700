package CanvasApp.ViewModel.ShapeViewModel.Cmd;

import CanvasApp.ViewModel.ShapeViewModel.ShapeViewModel;
import Command.Command;

import java.awt.event.MouseEvent;

public class DragMouse implements Command {
    private final ShapeViewModel shapeViewModel;
    private final int x;
    private final int y;

    public DragMouse(ShapeViewModel shapeViewModel, MouseEvent mouseEvent) {
        this.shapeViewModel = shapeViewModel;
        this.x = mouseEvent.getX();
        this.y = mouseEvent.getY();
    }

    @Override
    public void execute() {
        shapeViewModel.dragMouse(x, y);
    }
}

package CanvasApp.Model.Cmd;

import CanvasApp.Model.Decorator.ShapeDecorator;
import CanvasApp.Model.ShapeModel;
import Command.Command;

public class DecorateCmd implements Command {
    private final ShapeModel decorated;
    private final ShapeDecorator decorator;
    private final ShapeModel canvas;

    public DecorateCmd(ShapeModel decorated, ShapeDecorator decorator, ShapeModel canvas) {
        this.decorated = decorated;
        this.decorator = decorator;
        this.canvas = canvas;
    }

    @Override
    public void execute() {
        canvas.remove(decorated);
        canvas.add(decorator);
        System.out.println("[DecorateCmd] decorator : " + decorator.getClass() + ", decorated : " + decorated.getClass());
    }
}

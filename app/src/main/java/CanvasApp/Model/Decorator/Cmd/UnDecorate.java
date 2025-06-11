package CanvasApp.Model.Decorator.Cmd;

import CanvasApp.Model.Decorator.ShapeDecorator;
import Command.Command;

public class UnDecorate implements Command {
    private final ShapeDecorator decoChained;
    private final Class<? extends ShapeDecorator> decoType;

    public UnDecorate(ShapeDecorator decoChained, Class<? extends ShapeDecorator> decoType) {
        this.decoChained = decoChained;
        this.decoType = decoType;
    }

    @Override
    public void execute() {
        decoChained.removeDecorator(decoType, null,decoChained);
    }
}

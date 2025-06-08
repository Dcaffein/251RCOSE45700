package CanvasApp.Model.Cmd;

import CanvasApp.Model.Decorator.ShapeDecorator;
import CanvasApp.Model.ShapeModel;
import CanvasApp.Model.HasText;
import Command.Command;

public class ChangeTextCmd implements Command {
    private final ShapeModel shape;
    private final String newText;

    public ChangeTextCmd(ShapeModel shape, String newText) {
        this.shape = shape;
        this.newText = newText;
    }

    @Override
    public void execute() {
        updateShapeTextById(shape, newText);
    }

    private void updateShapeTextById(ShapeModel shapeModel, String newText) {
        HasText hasText = findHasText(shapeModel);
        if (hasText != null) {
            System.out.println("[ChangeTextCmd] hasText : " + hasText.getClass().getSimpleName());
            hasText.setText(newText);
        }
    }

    private HasText findHasText(ShapeModel model) {
        if (model instanceof HasText modelWhichHasText) {
            return modelWhichHasText;
        }
        if (model instanceof ShapeDecorator decorator) {
            return findHasText(decorator.getDecorated());
        }
        return null;
    }
}

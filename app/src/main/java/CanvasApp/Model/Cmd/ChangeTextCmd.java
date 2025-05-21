package CanvasApp.Model.Cmd;

import CanvasApp.Model.Composite.Leaf.TextModel;
import CanvasApp.Model.Decorator.ShapeDecorator;
import CanvasApp.Model.Decorator.TextInShape;
import CanvasApp.Model.ShapeModel;
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
        if (shapeModel instanceof ShapeDecorator shapeDecorator) {
            if(shapeDecorator instanceof TextInShape textInShape){
                textInShape.setText(newText);
            } else {
                updateShapeTextById(shapeDecorator.getDecorated(),newText);
            }
        } else if (shapeModel instanceof TextModel textModel) {
            textModel.setText(newText);
        }
    }
}

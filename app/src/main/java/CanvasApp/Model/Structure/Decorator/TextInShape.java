package CanvasApp.Model.Structure.Decorator;

import CanvasApp.Model.Event.ShapeModelTextChanged;
import CanvasApp.Model.ShapeModel;
import CanvasApp.Model.Structure.HasText;

public class TextInShape extends ShapeDecorator implements HasText {
    private String text;

    public TextInShape(ShapeModel decorated, String text) {
        super(decorated);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String newText) {
        String oldText = this.text;
        if (oldText == null || !oldText.equals(newText)) {
            this.text = newText;
            notify(new ShapeModelTextChanged(this, this.text));
        }
    }
}
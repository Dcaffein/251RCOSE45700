package CanvasApp.Model.Decorator;

import CanvasApp.Model.Event.ShapeModelTextChanged;
import CanvasApp.Model.ShapeModel;

public class TextInShape extends ShapeDecorator {
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
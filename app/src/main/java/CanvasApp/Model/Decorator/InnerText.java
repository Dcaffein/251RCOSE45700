package CanvasApp.Model.Decorator;

import CanvasApp.Model.Decorator.Event.DecoratorStateChanged;
import CanvasApp.Model.Event.ShapeTextChanged;
import CanvasApp.Model.ShapeModel;
import CanvasApp.Model.HasText;

public class InnerText extends ShapeDecorator implements HasText {
    private String text;

    public InnerText(ShapeModel decorated, String text) {
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
            notify(new DecoratorStateChanged(this));
        }
    }

    @Override
    public void updateOwnState(ShapeDecorator decorator) {
        if(decorator instanceof InnerText textDeco) {
            setText(textDeco.getText());
        }
    }
}
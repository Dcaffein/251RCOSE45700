package CanvasApp.Model.Event;

import CanvasApp.Model.ShapeModel;

public class ShapeTextChanged extends ShapeEvent {
    private final String newText;

    public ShapeTextChanged(ShapeModel source, String newText) {
        super(source);
        this.newText = newText;
    }

    public String getNewText() {
        return newText;
    }
}
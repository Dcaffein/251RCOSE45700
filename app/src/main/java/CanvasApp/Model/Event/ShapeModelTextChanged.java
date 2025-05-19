package CanvasApp.Model.Event;

import CanvasApp.Model.ShapeModel;

public class ShapeModelTextChanged extends ShapeEvent {
    private final String newText;

    public ShapeModelTextChanged(ShapeModel source, String newText) {
        super(source);
        this.newText = newText;
    }

    public String getNewText() {
        return newText;
    }
}
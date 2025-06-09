package CanvasApp.Model.Event;

import CanvasApp.Model.ShapeModel;
import Observer.Event;

public class ShapeTextChanged extends Event<ShapeModel> {
    private final String newText;

    public ShapeTextChanged(ShapeModel source, String newText) {
        super(source);
        this.newText = newText;
    }

    public String getNewText() {
        return newText;
    }
}
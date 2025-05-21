package CanvasApp.ViewModel.Data.ShapeData.Event;

import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

public class ShapeDataTextChanged extends ShapeDataEvent {
    private String text;

    public ShapeDataTextChanged(ShapeData shapeData, String text) {
        super(shapeData);
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

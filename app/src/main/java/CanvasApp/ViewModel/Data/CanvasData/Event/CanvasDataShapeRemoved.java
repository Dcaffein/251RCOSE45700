package CanvasApp.ViewModel.Data.CanvasData.Event;

import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

public class CanvasDataShapeRemoved extends CanvasDataEvent<ShapeData> {

    public CanvasDataShapeRemoved(ShapeData shapeData) {
        super(shapeData);
    }
}

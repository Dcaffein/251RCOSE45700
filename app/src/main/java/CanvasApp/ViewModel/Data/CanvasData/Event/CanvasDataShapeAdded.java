package CanvasApp.ViewModel.Data.CanvasData.Event;

import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

public class CanvasDataShapeAdded extends CanvasDataEvent<ShapeData> {
    public CanvasDataShapeAdded(ShapeData shapeData) {
        super(shapeData);
    }
}

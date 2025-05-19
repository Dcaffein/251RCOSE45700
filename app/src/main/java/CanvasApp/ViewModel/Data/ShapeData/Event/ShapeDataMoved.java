package CanvasApp.ViewModel.Data.ShapeData.Event;

import CanvasApp.ViewModel.Data.ShapeData.ShapeData;
import Observer.Observer;

public class ShapeDataMoved extends ShapeDataEvent {
    public ShapeDataMoved(ShapeData shapeData) {
        super(shapeData);
    }
}

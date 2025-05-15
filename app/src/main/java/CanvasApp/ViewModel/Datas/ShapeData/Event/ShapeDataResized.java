package CanvasApp.ViewModel.Datas.ShapeData.Event;

import CanvasApp.ViewModel.Datas.ShapeData.ShapeData;

public class ShapeDataResized extends ShapeDataEvent {
    public ShapeDataResized(ShapeData shapeData) {
        super(shapeData);
    }

    @Override
    public void dispatchShapeDataEvent(ShapeDataObserver o) {
        o.onResized(this);
    }
}

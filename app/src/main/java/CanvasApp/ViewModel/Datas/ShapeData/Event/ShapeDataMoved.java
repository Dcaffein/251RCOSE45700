package CanvasApp.ViewModel.Datas.ShapeData.Event;

import CanvasApp.ViewModel.Datas.ShapeData.ShapeData;

public class ShapeDataMoved extends ShapeDataEvent {
    public ShapeDataMoved(ShapeData shapeData) {
        super(shapeData);
    }

    @Override
    public void dispatchShapeDataEvent(ShapeDataObserver o) {
        o.onMoved(this);
    }
}

package CanvasApp.ViewModel.Datas.ShapeData.Event;

import CanvasApp.ViewModel.Datas.ShapeData.ShapeData;

public class ShapeDataRealigned extends ShapeDataEvent {
    public ShapeDataRealigned(ShapeData source) {
        super(source);
    }

    @Override
    public void dispatchShapeDataEvent(ShapeDataObserver o) {
        o.onRealigned(this);
    }
} 
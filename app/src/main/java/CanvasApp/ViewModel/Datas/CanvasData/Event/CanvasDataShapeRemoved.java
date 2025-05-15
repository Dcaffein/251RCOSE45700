package CanvasApp.ViewModel.Datas.CanvasData.Event;

import CanvasApp.ViewModel.Datas.ShapeData.ShapeData;

public class CanvasDataShapeRemoved extends CanvasDataEvent<ShapeData> {

    public CanvasDataShapeRemoved(ShapeData shapeData) {
        super(shapeData);
    }

    @Override
    public void dispatchCanvasDataEvent(CanvasDataObserver o) {
        o.onShapeRemoved(this);
    }
}

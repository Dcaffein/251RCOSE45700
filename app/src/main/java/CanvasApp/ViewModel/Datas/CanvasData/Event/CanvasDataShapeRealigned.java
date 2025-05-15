package CanvasApp.ViewModel.Datas.CanvasData.Event;

import CanvasApp.ViewModel.Datas.ShapeData.ShapeData;

public class CanvasDataShapeRealigned extends CanvasDataEvent<ShapeData> {

    public CanvasDataShapeRealigned(ShapeData shapeData) {
        super(shapeData);
    }

    @Override
    public void dispatchCanvasDataEvent(CanvasDataObserver o) {
        o.onRealigned(this);
    }
}

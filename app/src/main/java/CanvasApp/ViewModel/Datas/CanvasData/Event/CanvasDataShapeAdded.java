package CanvasApp.ViewModel.Datas.CanvasData.Event;

import CanvasApp.Factory.ShapeFactory;
import CanvasApp.ViewModel.Datas.ShapeData.ShapeData;

public class CanvasDataShapeAdded extends CanvasDataEvent<ShapeData> {
    public ShapeFactory shapeFactory;

    public CanvasDataShapeAdded(ShapeData shapeData,ShapeFactory shapeFactory) {
        super(shapeData);
        this.shapeFactory = shapeFactory;
    }

    @Override
    public void dispatchCanvasDataEvent(CanvasDataObserver o) {
        o.onShapeAdded(this);
    }
}

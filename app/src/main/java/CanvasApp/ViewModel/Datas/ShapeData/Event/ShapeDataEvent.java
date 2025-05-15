package CanvasApp.ViewModel.Datas.ShapeData.Event;

import CanvasApp.ViewModel.Datas.ShapeData.ShapeData;
import Observer.Event;
import Observer.Observer;

public abstract class ShapeDataEvent extends Event<ShapeData> {

    public ShapeDataEvent(ShapeData shapeData) {
        super(shapeData);
    }

    @Override
    public void dispatch(Observer o) {
        if (o instanceof ShapeDataObserver observer) {
            dispatchShapeDataEvent(observer);
        }
    }
    public abstract void dispatchShapeDataEvent(ShapeDataObserver o);
}

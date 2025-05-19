package CanvasApp.ViewModel.Data.ShapeData.Event;

import CanvasApp.ViewModel.Data.ShapeData.ShapeData;
import Observer.Event;
import Observer.Observer;

public abstract class ShapeDataEvent extends Event<ShapeData> {

    public ShapeDataEvent(ShapeData shapeData) {
        super(shapeData);
    }

    @Override
    public void dispatch(Observer o) {
        if (o instanceof ShapeDataObserver shapeDataObserver) {
            shapeDataObserver.onUpdate(this);
        }
    }
}

package CanvasApp.ViewModel.Data.ShapeData.Decorator;

import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataEvent;

public abstract class ShapeDataDecoratorEvent extends ShapeDataEvent {
    private ShapeDataDecorator decorator;

    public ShapeDataDecoratorEvent(ShapeDataDecorator ShapeDataDecorator) {
        super(ShapeDataDecorator);
        this.decorator = ShapeDataDecorator;
    }

    public ShapeDataDecorator getDecorator() {
        return decorator;
    }
}

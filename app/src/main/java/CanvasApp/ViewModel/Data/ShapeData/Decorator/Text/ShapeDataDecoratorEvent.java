package CanvasApp.ViewModel.Data.ShapeData.Decorator.Text;

import CanvasApp.ViewModel.Data.ShapeData.Decorator.ShapeDataDecorator;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataEvent;

public abstract class ShapeDataDecoratorEvent extends ShapeDataEvent {
    private final ShapeDataDecorator decorator;

    public ShapeDataDecoratorEvent(ShapeDataDecorator ShapeDataDecorator) {
        super(ShapeDataDecorator);
        this.decorator = ShapeDataDecorator;
    }

    public ShapeDataDecorator getDecorator() {
        return decorator;
    }
}

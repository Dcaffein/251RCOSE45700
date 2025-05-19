package CanvasApp.View.ShapeView.Decorator;

import CanvasApp.View.ShapeView.ShapeView;
import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.Data.ShapeData.Decorator.ShapeDataDecorator;

public abstract class ShapeDecoratorView extends ShapeView {
    protected ShapeView decorated;

    public ShapeDecoratorView(ShapeDataDecorator shapeData, CanvasVM viewModel, ShapeView decorated) {
        super(shapeData, viewModel);
        this.decorated = decorated;
    }

    public ShapeView getDecorated() {
        return decorated;
    }

    @Override
    public String getId() {
        return shapeData.getId();
    }

    @Override
    public void resizeShape(int dw, int dh) {

    }

    @Override
    public void moveShape(int dx, int dy) {

    }
}

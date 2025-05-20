package CanvasApp.ViewModel.Data.ShapeData.Decorator;

import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

public abstract class ShapeDataDecorator extends ShapeData {
    private ShapeData decorated;

    public ShapeDataDecorator(ShapeModel source, ShapeData decorated) {
        super(source);
        this.decorated = decorated;
    }

    public ShapeData getDecorated() {
        return decorated;
    }

    @Override
    public void updatePosition(int x, int y) {
        super.updatePosition(x, y);
        if (decorated != null) {
            decorated.updatePosition(x, y);
        }
    }

    @Override
    public void updateSize(int width, int height) {
        super.updateSize(width, height);
        if (decorated != null) {
            decorated.updateSize(width, height);
        }
    }

    @Override
    public void updateZ(int z) {
        super.updateZ(z);
        if (decorated != null) {
            decorated.updateZ(z);
        }
    }
}

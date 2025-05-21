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
    public void move(int x, int y) {
        super.move(x, y);
        if (decorated != null) {
            decorated.move(x, y);
        }
    }

    @Override
    public void resize(int w, int h) {
        super.resize(w, h);
        if (decorated != null) {
            decorated.resize(w, h);
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

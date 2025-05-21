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
        if (decorated != null) {
            decorated.move(x, y);
        }
    }

    @Override
    public void resize(int w, int h) {
        if (decorated != null) {
            decorated.resize(w, h);
        }
    }

    @Override
    public void updateZ(int z) {
        if (decorated != null) {
            decorated.updateZ(z);
        }
    }

    @Override
    public void setSelected(boolean selected) {
        if(decorated != null) {
            decorated.setSelected(selected);
        }
    }

    @Override
    public int getX(){
        return decorated.getX();
    }

    @Override
    public int getY(){
        return decorated.getY();
    }

    @Override
    public int getW(){
        return decorated.getW();
    }

    @Override
    public int getH(){
        return decorated.getH();
    }

    @Override
    public int getZ(){
        return decorated.getZ();
    }
}

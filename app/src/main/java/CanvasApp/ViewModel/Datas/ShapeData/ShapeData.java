package CanvasApp.ViewModel.Datas.ShapeData;

import CanvasApp.Model.Shape.ShapeModel;
import CanvasApp.ViewModel.Datas.ShapeData.Event.ShapeDataMoved;
import CanvasApp.ViewModel.Datas.ShapeData.Event.ShapeDataRealigned;
import CanvasApp.ViewModel.Datas.ShapeData.Event.ShapeDataResized;
import Observer.Observable;

public class ShapeData extends Observable implements ReadOnlyShapeData{
    private final String id;
    private final ShapeModel source;
    private int x;
    private int y;
    private int width;
    private int height;
    private int z;
    private int padding = 2;

    public ShapeData(ShapeModel source) {
        this.id = source.getId();
        this.source = source;
        this.x = source.getX();
        this.y = source.getY();
        this.width = source.getW();
        this.height = source.getH();
        this.z = source.getZ();
    }

    public String getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getW() {
        return width;
    }

    public int getH() {
        return height;
    }

    @Override
    public int getPadding() {
        return padding;
    }

    public int getZ() {
        return z;
    }

    public void updatePosition(int x, int y) {
        this.x = x;
        this.y = y;
        notify(new ShapeDataMoved(this));
    }

    public void updateSize(int width, int height) {
        this.width = width;
        this.height = height;
        notify(new ShapeDataResized(this));
    }

    public void updateZ(int z) {
        this.z = z;
        notify(new ShapeDataRealigned(this));
    }
}

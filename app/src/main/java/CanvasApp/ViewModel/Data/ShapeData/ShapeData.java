package CanvasApp.ViewModel.Data.ShapeData;

import CanvasApp.Factory.ShapeFactory;
import CanvasApp.Factory.ShapeFactoryRegistry;
import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataMoved;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataRealigned;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataResized;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataSelected;
import Observer.Observable;

public class ShapeData extends Observable implements ReadOnlyShapeData{
    private final String id;
    private int x;
    private int y;
    private int w;
    private int h;
    private int z;
    private int padding = 5;
    private ShapeFactory factory;
    private boolean selected = false;

    public ShapeData(ShapeModel source) {
        this.id = source.getId();
        this.x = source.getX();
        this.y = source.getY();
        this.w = source.getW();
        this.h = source.getH();
        this.z = source.getZ();
        this.factory = ShapeFactoryRegistry.factoryFor(source.getClass());
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
        return w;
    }

    public int getH() {
        return h;
    }

    public int getPadding() {
        return padding;
    }

    public int getZ() {
        return z;
    }

    public ShapeFactory getFactory() {
        return factory;
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
        notify(new ShapeDataMoved(this));
    }

    public void resize(int w, int h) {
        this.w = w;
        this.h = h;
        notify(new ShapeDataResized(this));
    }

    public void updateZ(int z) {
        this.z = z;
        notify(new ShapeDataRealigned(this));
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        notify(new ShapeDataSelected(this));
    }

    public boolean getSelected() {
        return this.selected;
    }
}

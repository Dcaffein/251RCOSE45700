package CanvasApp.ViewModel.ShapeData;

import CanvasApp.ViewModel.ShapeData.Observer.ShapeDataMoved;
import CanvasApp.ViewModel.ShapeData.Observer.ShapeDataResized;
import Observer.Observable;
import CanvasApp.Model.Shape.Observer.ShapeModelMoved;
import CanvasApp.Model.Shape.Observer.ShapeModelResized;
import CanvasApp.Model.Shape.ShapeModel;


public class ShapeData extends Observable implements ReadOnlyShapeData {
    private final String id;
    private int x;
    private int y;
    private int w;
    private int h;
    private int z;
    private int padding = 2;

    public ShapeData(ShapeModel shapeModel) {
        this.id = shapeModel.getId();
        this.x = shapeModel.getX();
        this.y = shapeModel.getY();
        this.w = shapeModel.getW();
        this.h = shapeModel.getH();
        this.z = shapeModel.getZ();
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
    public int getZ() {return z;}
    public int getPadding() {
        return padding;
    }

    public void moved(int x, int y) {
        this.x = x; this.y=y;
        notify(new ShapeDataMoved(id,x,y));
    }

    public void resized(int w, int h) {
        this.w = w; this.h = h;
        notify(new ShapeDataResized(id,w,h));
    }

    public void setZ(int z) {
        this.z = z;
    }
}

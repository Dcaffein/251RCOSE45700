package CanvasApp.ViewModel.Datas.ShapeData;

import Observer.Observer;

public interface ReadOnlyShapeData {
    String getId();
    int getX();
    int getY();
    int getW();
    int getH();
    int getPadding();
    void attach(Observer Observer);
}
package CanvasApp.View.CanvasView;

import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

import java.awt.*;

public interface CanvasViewContext {
    void createShapeView(ShapeData shapeData);
    void addChildViewOnLayeredPane(Component child);
    void removeChildViewOnLayeredPane(Component child);
    void setChildViewLayerOnLayeredPane(Component child,int layer);
    Component findComponentById(String id);
    void setGlassPaneVisible(boolean isVisible);
}

package CanvasApp.View.CanvasView;

import CanvasApp.View.ShapeView.ShapeView;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

import java.awt.*;

public interface CanvasViewContext {
    ShapeView createChildShapeView(ShapeData shapeData);
    void addChildViewOnLayeredPane(Component child);
    void removeChildViewOnLayeredPane(Component child);
    void setChildViewLayerOnLayeredPane(Component child,int layer);
    Component findComponentById(String id);
    void setGlassPaneVisible(boolean isVisible);

    void repaint();
}

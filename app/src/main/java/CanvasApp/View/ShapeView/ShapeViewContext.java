package CanvasApp.View.ShapeView;

import CanvasApp.View.ShapeView.ShapeViewState.ShapeViewState;

import java.awt.*;

public interface ShapeViewContext {
    void setCurrentState(ShapeViewState state);

    //command
    void moveShape(int dx, int dy);
    void select(String id);
    void multiSelect(String id);
    void resizeShape(int dw, int dh);

    //variable
    boolean isCorner(Point p);
    String getId();  // shapeProp.getId() 대신
    Point getDragStart();
    void setDragStart(Point p);

    //render
    void repaint();
    void setBounds(int x, int y, int w, int h);
}


package CanvasApp.Model.Decorator;

import CanvasApp.Model.ShapeModel;

import java.awt.*;

public class Shadow extends ShapeDecorator {
    private int color;
    private int border;

    public Shadow(ShapeModel decorated,int color, int border) {
        super(decorated);
        this.color = color;
        this.border = border;
    }

    public int getColor() {
        return color;
    }

//    public void setColor(String color) {
//        this.color = color;
//        notify
//    }

    public int getBorder() {
        return border;
    }

//    public void setBorder(int border) {
//        this.border = border;
//        notify
//    }
}

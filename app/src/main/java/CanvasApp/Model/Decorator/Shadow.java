package CanvasApp.Model.Decorator;

import CanvasApp.Model.Event.ShapeModelTextChanged;
import CanvasApp.Model.ShapeModel;

import java.awt.*;

public class Shadow extends ShapeDecorator {
    private Color color;
    private int border;

    public Shadow(ShapeModel decorated,Color color, int border) {
        super(decorated);
        this.color = color;
        this.border = border;
    }

    public Color getColor() {
        return color;
    }

    public int getBorder() {
        return border;
    }

    public void setColor(Color color) {
        this.color = color;
        //notify
    }

    public void setBorder(int border) {
        this.border = border;
        //notify
    }
}

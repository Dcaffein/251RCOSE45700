package CanvasApp.ViewModel.Data.ShapeData.Decorator.Shadow;

import CanvasApp.Model.Decorator.Shadow;
import CanvasApp.ViewModel.Data.ShapeData.Decorator.ShapeDataDecorator;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

import java.awt.*;

public class ShadowData extends ShapeDataDecorator {
    private Color color;
    private int border;

    public ShadowData(Shadow model, ShapeData decorated) {
        super(model, decorated);
        this.color = model.getColor();
        this.border = model.getBorder();
    }

    public Color getColor() { return color; }

//    public void setColor(Color color) {
//        this.color = color;
//        notify
//    }

    public int getBorder() { return border; }

//    public void setBorder(int border) {
//        this.border = border;
//        notify
//    }
}

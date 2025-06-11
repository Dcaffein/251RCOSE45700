package CanvasApp.Model.Decorator;

import CanvasApp.Model.Decorator.Event.DecoratorStateChanged;
import CanvasApp.Model.ShapeModel;


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

    public int getBorder() {
        return border;
    }

    @Override
    public void updateOwnState(ShapeDecorator decorator) {
        if(decorator instanceof Shadow shadow){
            this.color = shadow.getColor();
            this.border = shadow.getBorder();
            notify(new DecoratorStateChanged(this));
        }
    }
}

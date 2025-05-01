package CanvasApp.Model.Canvas.Observer.ConcreteShapeAdded;

import CanvasApp.Model.Canvas.Observer.CanvasModelShapeAdded;
import CanvasApp.Model.Factory.RectFactory;
import CanvasApp.Model.Factory.ShapeFactory;

public class RectAddedShapeAdded extends CanvasModelShapeAdded {
    public RectAddedShapeAdded(String id) {
        super(id);
    }

    @Override
    public ShapeFactory getShapeFactory() {
        return RectFactory.getInstance();
    }

}

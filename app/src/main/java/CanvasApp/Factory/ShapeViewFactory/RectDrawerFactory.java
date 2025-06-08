package CanvasApp.Factory.ShapeViewFactory;

import CanvasApp.Model.ShapeModel;
import CanvasApp.View.ShapeView.Drawer.Drawer;
import CanvasApp.View.ShapeView.Drawer.RectDrawer;

public class RectDrawerFactory implements DrawerFactory{
    private static final RectDrawerFactory instance = new RectDrawerFactory();
    public RectDrawerFactory(){}
    public static RectDrawerFactory getInstance() {
        return instance;
    }

    @Override
    public Drawer createDrawer(ShapeModel shapeModel) {
        return new RectDrawer();
    }
}

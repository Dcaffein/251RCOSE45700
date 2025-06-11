package CanvasApp.Factory.ShapeView;

import CanvasApp.Model.ShapeModel;
import CanvasApp.View.ShapeView.Drawer.Drawer;
import CanvasApp.View.ShapeView.Drawer.EllipseDrawer;

public class EllipseDrawerFactory implements DrawerFactory{
    private static final EllipseDrawerFactory instance = new EllipseDrawerFactory();
    public EllipseDrawerFactory(){}
    public static EllipseDrawerFactory getInstance() {
        return instance;
    }

    @Override
    public Drawer createDrawer(ShapeModel shapeModel) {
        return new EllipseDrawer();
    }
}

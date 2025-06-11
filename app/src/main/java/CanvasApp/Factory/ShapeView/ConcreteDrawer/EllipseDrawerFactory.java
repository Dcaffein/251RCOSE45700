package CanvasApp.Factory.ShapeView.ConcreteDrawer;

import CanvasApp.Factory.ShapeView.DrawerFactory;
import CanvasApp.View.ShapeView.Drawer.Drawer;
import CanvasApp.View.ShapeView.Drawer.EllipseDrawer;

public class EllipseDrawerFactory implements DrawerFactory {
    private static final EllipseDrawerFactory instance = new EllipseDrawerFactory();
    public EllipseDrawerFactory(){}
    public static EllipseDrawerFactory getInstance() {
        return instance;
    }

    @Override
    public Drawer createDrawer( ) {
        return new EllipseDrawer();
    }
}

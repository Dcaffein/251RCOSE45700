package CanvasApp.Factory.ShapeView.ConcreteDrawer;

import CanvasApp.Factory.ShapeView.DrawerFactory;
import CanvasApp.Model.ShapeModel;
import CanvasApp.View.ShapeView.Drawer.Drawer;
import CanvasApp.View.ShapeView.Drawer.TriangleDrawer;

public class TriangleDrawerFactory implements DrawerFactory {
    private static final TriangleDrawerFactory instance = new TriangleDrawerFactory();
    public TriangleDrawerFactory(){}
    public static TriangleDrawerFactory getInstance() {
        return instance;
    }

    @Override
    public Drawer createDrawer() {
        return new TriangleDrawer();
    }
}

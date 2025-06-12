package CanvasApp.Factory.ShapeView.ConcreteDrawer;

import CanvasApp.Factory.ShapeView.DrawerFactory;
import CanvasApp.View.ShapeView.Drawer.Drawer;
import CanvasApp.View.ShapeView.Drawer.InnerTextDrawer;

public class InnerTextDrawerFactory implements DrawerFactory {
    private static final InnerTextDrawerFactory instance = new InnerTextDrawerFactory();
    public InnerTextDrawerFactory(){}
    public static InnerTextDrawerFactory getInstance() {
        return instance;
    }

    @Override
    public Drawer createDrawer() {
        return new InnerTextDrawer();
    }
}

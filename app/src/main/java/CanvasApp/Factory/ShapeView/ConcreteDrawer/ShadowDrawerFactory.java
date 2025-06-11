package CanvasApp.Factory.ShapeView.ConcreteDrawer;

import CanvasApp.Factory.ShapeView.DrawerFactory;
import CanvasApp.Model.ShapeModel;
import CanvasApp.View.ShapeView.Drawer.Drawer;
import CanvasApp.View.ShapeView.Drawer.ShadowDrawer;

public class ShadowDrawerFactory implements DrawerFactory {
    private static final ShadowDrawerFactory instance = new ShadowDrawerFactory();
    public ShadowDrawerFactory(){}
    public static ShadowDrawerFactory getInstance() {
        return instance;
    }

    @Override
    public Drawer createDrawer( ) {
        return new ShadowDrawer();
    }
}

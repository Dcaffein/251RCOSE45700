package CanvasApp.Factory.ShapeView;

import CanvasApp.Model.ShapeModel;
import CanvasApp.View.ShapeView.Drawer.Drawer;
import CanvasApp.View.ShapeView.Drawer.ShadowDrawer;

public class ShadowDrawerFactory implements DrawerFactory{
    private static final ShadowDrawerFactory instance = new ShadowDrawerFactory();
    public ShadowDrawerFactory(){}
    public static ShadowDrawerFactory getInstance() {
        return instance;
    }

    @Override
    public Drawer createDrawer(ShapeModel shapeModel) {
        return new ShadowDrawer();
    }
}

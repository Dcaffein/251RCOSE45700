package CanvasApp.Factory.ShapeView.ConcreteDrawer;

import CanvasApp.Factory.ShapeView.DrawerFactory;
import CanvasApp.View.ShapeView.Drawer.Drawer;
import CanvasApp.View.ShapeView.Drawer.TextDrawer;

public class TextDrawerFactory implements DrawerFactory {
    private static final TextDrawerFactory instance = new TextDrawerFactory();
    public TextDrawerFactory(){}
    public static TextDrawerFactory getInstance() {
        return instance;
    }

    @Override
    public Drawer createDrawer( ) {
        return new TextDrawer();
    }
}

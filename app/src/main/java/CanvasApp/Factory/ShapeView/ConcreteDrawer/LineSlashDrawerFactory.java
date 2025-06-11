package CanvasApp.Factory.ShapeView.ConcreteDrawer;

import CanvasApp.Factory.ShapeView.DrawerFactory;
import CanvasApp.Model.ShapeModel;
import CanvasApp.View.ShapeView.Drawer.Drawer;
import CanvasApp.View.ShapeView.Drawer.LineSlashDrawer;

public class LineSlashDrawerFactory implements DrawerFactory {
    private static final LineSlashDrawerFactory instance = new LineSlashDrawerFactory();
    public LineSlashDrawerFactory(){}
    public static LineSlashDrawerFactory getInstance() {
        return instance;
    }

    @Override
    public Drawer createDrawer() {
        return new LineSlashDrawer();
    }
}

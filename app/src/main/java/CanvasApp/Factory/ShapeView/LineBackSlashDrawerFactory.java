package CanvasApp.Factory.ShapeView;

import CanvasApp.Model.ShapeModel;
import CanvasApp.View.ShapeView.Drawer.Drawer;
import CanvasApp.View.ShapeView.Drawer.LineBackSlashDrawer;

public class LineBackSlashDrawerFactory implements DrawerFactory{
    private static final LineBackSlashDrawerFactory instance = new LineBackSlashDrawerFactory();
    public LineBackSlashDrawerFactory(){}
    public static LineBackSlashDrawerFactory getInstance() {
        return instance;
    }

    @Override
    public Drawer createDrawer(ShapeModel shapeModel) {
        return new LineBackSlashDrawer();
    }
}

package CanvasApp.Factory.ShapeViewFactory;

import CanvasApp.Model.ShapeModel;
import CanvasApp.View.ShapeView.Drawer.Drawer;

public interface DrawerFactory {
    Drawer createDrawer(ShapeModel shapeModel);
}

package CanvasApp.Factory.ShapeViewFactory;

import CanvasApp.Factory.ShapeFactoryRegistry;
import CanvasApp.View.ShapeView.Drawer.Drawer;
import CanvasApp.View.ShapeView.ShapeView;
import CanvasApp.ViewModel.ShapeViewModel.ShapeViewModel;

public class ShapeViewFactory {
    private static final ShapeViewFactory instance = new ShapeViewFactory();
    public ShapeViewFactory(){}
    public static ShapeViewFactory getInstance() {
        return instance;
    }

    public ShapeView createShapeView(ShapeViewModel shapeViewModel) {
        DrawerFactory drawerFactory = ShapeFactoryRegistry.factoryFor(shapeViewModel.shape);
        Drawer drawer = drawerFactory.createDrawer(shapeViewModel.shape);
        return new ShapeView(shapeViewModel,drawer);
    }
}

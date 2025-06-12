package CanvasApp.Factory.ShapeView;

import CanvasApp.Factory.DrawerRegistry;
import CanvasApp.Model.Composite.ConcreteLeaf.TextModel;
import CanvasApp.View.ShapeView.BaseShapeView;
import CanvasApp.View.ShapeView.Drawer.Drawer;
import CanvasApp.View.ShapeView.ShapeView;
import CanvasApp.View.ShapeView.TextView;
import CanvasApp.ViewModel.ShapeViewModel.ShapeViewModel;

public class ShapeViewFactory {
    private static final ShapeViewFactory instance = new ShapeViewFactory();
    public ShapeViewFactory(){}
    public static ShapeViewFactory getInstance() {
        return instance;
    }

    public ShapeView createShapeView(ShapeViewModel shapeViewModel) {
        DrawerFactory drawerFactory = DrawerRegistry.factoryFor(shapeViewModel.getShape());
        Drawer drawer = drawerFactory.createDrawer();
        ShapeView shapeView;
        if(shapeViewModel.getShape() instanceof TextModel){
            shapeView = new TextView(shapeViewModel, drawer);
            System.out.println("createShapeView : " + shapeView.getClass());
            System.out.println("drawer : " + drawer);
        }
//        else if (shapeViewModel.getShape() instanceof ImageModel){
//            shapeView = new ImageView(shapeViewModel, drawer);
//        }
        else {
            shapeView = new BaseShapeView(shapeViewModel, drawer);
        }
        return shapeView;
    }
}

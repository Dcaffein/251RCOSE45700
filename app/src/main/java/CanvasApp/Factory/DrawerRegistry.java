package CanvasApp.Factory;

import CanvasApp.Factory.Shape.Decorator.InnerTextFactory;
import CanvasApp.Factory.ShapeView.ConcreteDrawer.*;
import CanvasApp.Factory.ShapeView.DrawerFactory;
import CanvasApp.Model.Composite.ConcreteLeaf.*;
import CanvasApp.Model.Decorator.InnerText;
import CanvasApp.Model.Decorator.Shadow;
import CanvasApp.Model.ShapeModel;
import CanvasApp.View.ShapeView.Drawer.InnerTextDrawer;

import java.util.HashMap;
import java.util.Map;

public final class DrawerRegistry {
    private static final Map<Class<? extends ShapeModel>, DrawerFactory> registry = new HashMap<>();

    static {
        registry.put(RectModel.class, RectDrawerFactory.getInstance());
        registry.put(EllipseModel.class, EllipseDrawerFactory.getInstance());
        registry.put(TriangleModel.class, TriangleDrawerFactory.getInstance());
        registry.put(TextModel.class, TextDrawerFactory.getInstance());
//        registry.put(ImageModel.class, ImageFactory.getInstance());
       registry.put(LineBackSlashModel.class, LineBackSlashDrawerFactory.getInstance());
       registry.put(LineSlashModel.class, LineSlashDrawerFactory.getInstance());
        registry.put(InnerText.class, InnerTextDrawerFactory.getInstance());
        registry.put(Shadow.class, ShadowDrawerFactory.getInstance());
    }

    public static DrawerFactory factoryFor(ShapeModel model) {
        return registry.get(model.getClass());
    }
}

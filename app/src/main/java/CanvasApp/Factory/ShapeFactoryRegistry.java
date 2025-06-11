package CanvasApp.Factory;

import CanvasApp.Factory.ShapeView.ConcreteDrawer.*;
import CanvasApp.Factory.ShapeView.DrawerFactory;
import CanvasApp.Model.Composite.ConcreteLeaf.RectModel;
import CanvasApp.Model.Composite.ConcreteLeaf.EllipseModel;
import CanvasApp.Model.Composite.ConcreteLeaf.TriangleModel;
import CanvasApp.Model.Composite.ConcreteLeaf.LineBackSlashModel;
import CanvasApp.Model.Composite.ConcreteLeaf.LineSlashModel;
import CanvasApp.Model.Decorator.InnerText;
import CanvasApp.Model.Decorator.Shadow;
import CanvasApp.Model.ShapeModel;

import java.util.HashMap;
import java.util.Map;

public final class ShapeFactoryRegistry {
    private static final Map<Class<? extends ShapeModel>, DrawerFactory> registry = new HashMap<>();

    static {
        registry.put(RectModel.class, RectDrawerFactory.getInstance());
        registry.put(EllipseModel.class, EllipseDrawerFactory.getInstance());
        registry.put(TriangleModel.class, TriangleDrawerFactory.getInstance());
//        registry.put(TextModel.class, TextFactory.getInstance());
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

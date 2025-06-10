package CanvasApp.Factory;

import CanvasApp.Factory.ShapeView.DrawerFactory;
import CanvasApp.Factory.ShapeView.RectDrawerFactory;
import CanvasApp.Factory.ShapeView.ShadowDrawerFactory;
import CanvasApp.Model.Composite.ConcreteLeaf.RectModel;
import CanvasApp.Model.Decorator.Shadow;
import CanvasApp.Model.ShapeModel;

import java.util.HashMap;
import java.util.Map;

public final class ShapeFactoryRegistry {
    private static final Map<Class<? extends ShapeModel>, DrawerFactory> registry = new HashMap<>();

    static {
        registry.put(RectModel.class, RectDrawerFactory.getInstance());
        registry.put(Shadow.class, ShadowDrawerFactory.getInstance());
//        registry.put(EllipseModel.class, EllipseFactory.getInstance());
//        registry.put(TriangleModel.class, TriangleFactory.getInstance());
//        registry.put(TextModel.class, TextFactory.getInstance());
//        registry.put(ImageModel.class, ImageFactory.getInstance());
//        registry.put(LineBackSlashModel.class, LineBackSlashFactory.getInstance());
//        registry.put(LineSlashModel.class, LineSlashFactory.getInstance());
//        registry.put(TextInShape.class, DecoratorTextFactory.getInstance());
//        registry.put(Shadow.class, DecoratorShadowFactory.getInstance());
    }

    public static DrawerFactory factoryFor(ShapeModel model) {
        return registry.get(model.getClass());
    }
}

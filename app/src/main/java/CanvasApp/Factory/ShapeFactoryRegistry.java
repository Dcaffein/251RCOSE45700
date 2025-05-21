package CanvasApp.Factory;

import CanvasApp.Model.Structure.Composite.Leaf.EllipseModel;
import CanvasApp.Model.Structure.Composite.Leaf.ImageModel;
import CanvasApp.Model.Structure.Composite.Leaf.LineBackSlashModel;
import CanvasApp.Model.Structure.Composite.Leaf.LineSlashModel;
import CanvasApp.Model.Structure.Composite.Leaf.RectModel;
import CanvasApp.Model.Structure.Composite.Leaf.TextModel;
import CanvasApp.Model.Structure.Composite.Leaf.TriangleModel;
import CanvasApp.Model.Structure.Decorator.Shadow;
import CanvasApp.Model.Structure.Decorator.TextInShape;
import CanvasApp.Model.ShapeModel;

import java.util.HashMap;
import java.util.Map;

public final class ShapeFactoryRegistry {
    private static final Map<Class<? extends ShapeModel>, ShapeFactory> registry = new HashMap<>();

    static {
        registry.put(RectModel.class, RectFactory.getInstance());
        registry.put(EllipseModel.class, EllipseFactory.getInstance());
        registry.put(TriangleModel.class, TriangleFactory.getInstance());
        registry.put(TextModel.class, TextFactory.getInstance());
        registry.put(ImageModel.class, ImageFactory.getInstance());
        registry.put(LineBackSlashModel.class, LineBackSlashFactory.getInstance());
        registry.put(LineSlashModel.class, LineSlashFactory.getInstance());
        registry.put(TextInShape.class, DecoratorTextFactory.getInstance());
        registry.put(Shadow.class, DecoratorShadowFactory.getInstance());
    }

    public static ShapeFactory factoryFor(Class<? extends ShapeModel> modelClass) {
        return registry.get(modelClass);
    }

    public static ShapeFactory factoryFor(ShapeModel model) {
        return factoryFor(model.getClass());
    }
}

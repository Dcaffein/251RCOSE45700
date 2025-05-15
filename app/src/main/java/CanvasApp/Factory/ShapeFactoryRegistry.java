package CanvasApp.Factory;

import CanvasApp.Model.Shape.Composite.Leaf.RectModel;
import CanvasApp.Model.Shape.ShapeModel;

import java.util.HashMap;
import java.util.Map;

public final class ShapeFactoryRegistry {
    private static final Map<Class<? extends ShapeModel>, ShapeFactory> registry = new HashMap<>();

    static {
        registry.put(RectModel.class, RectFactory.getInstance());
    }

    public static ShapeFactory factoryFor(Class<? extends ShapeModel> modelClass) {
        return registry.get(modelClass);
    }

    public static ShapeFactory factoryFor(ShapeModel model) {
        return factoryFor(model.getClass());
    }
}

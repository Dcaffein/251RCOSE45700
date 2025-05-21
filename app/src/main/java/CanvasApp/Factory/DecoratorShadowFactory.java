package CanvasApp.Factory;

import CanvasApp.Model.Structure.Decorator.Shadow;
import CanvasApp.Model.ShapeModel;
import CanvasApp.View.ShapeView.Decorator.Shadow.ShadowAroundShapeView;
import CanvasApp.View.ShapeView.ShapeView;
import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.Data.ShapeData.Decorator.Shadow.ShadowData;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

import java.awt.*;

public class DecoratorShadowFactory extends ShapeFactory{
    private static final DecoratorShadowFactory instance = new DecoratorShadowFactory();
    private DecoratorShadowFactory() {}

    public static DecoratorShadowFactory getInstance() {
        return instance;
    }

    public Shadow createShapeDecorator(ShapeModel decorated, Color color, int border) {
        return new Shadow(decorated,color,border);
    }

    @Override
    public ShapeModel createShapeModel(String id, int x, int y, int w, int h, int z) {
        return null;
    }

    @Override
    public ShapeData createShapeData(ShapeModel shapeModel) {
        if (!(shapeModel instanceof Shadow decorator)) {
            throw new UnsupportedOperationException("DecoratorTextFactory supports only DecoratorText");
        }

        ShapeModel decorated = decorator.getDecorated();

        ShapeFactory factory = ShapeFactoryRegistry.factoryFor(decorated);
        return new ShadowData(decorator, factory.createShapeData(decorated));
    }

    @Override
    public ShapeView createShapeView(ShapeData shapeData, CanvasVM viewModel) {
        if (!(shapeData instanceof ShadowData shadowData)) {
            throw new UnsupportedOperationException("Expected TextInShapeData");
        }

        ShapeData decoratedData = shadowData.getDecorated();

        ShapeFactory factoryForDecorated = decoratedData.getFactory();
        ShapeView decoratedView = factoryForDecorated.createShapeView(decoratedData, viewModel);

        return new ShadowAroundShapeView(shadowData, viewModel, decoratedView);
    }
}

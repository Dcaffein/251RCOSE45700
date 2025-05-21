package CanvasApp.Factory;

import CanvasApp.Model.Structure.Decorator.TextInShape;
import CanvasApp.Model.ShapeModel;
import CanvasApp.View.ShapeView.Decorator.Text.TextInShapeView;
import CanvasApp.View.ShapeView.ShapeView;
import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.Data.ShapeData.Decorator.Text.TextInShapeData;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

public class DecoratorTextFactory extends ShapeFactory{
    private static final DecoratorTextFactory instance = new DecoratorTextFactory();
    private DecoratorTextFactory() {}

    public static DecoratorTextFactory getInstance() {
        return instance;
    }

    @Override
    public ShapeModel createShapeModel(String id, int x, int y, int w, int h, int z) {
        return null;
    }

    public TextInShape createShapeDecorator(ShapeModel decorated,String text) {
        return new TextInShape(decorated, text);
    }

    @Override
    public ShapeData createShapeData(ShapeModel shapeModel) {
        if (!(shapeModel instanceof TextInShape decorator)) {
            throw new UnsupportedOperationException("DecoratorTextFactory supports only DecoratorText");
        }

        ShapeModel decorated = decorator.getDecorated();

        ShapeFactory factory = ShapeFactoryRegistry.factoryFor(decorated);
        return new TextInShapeData(decorator, factory.createShapeData(decorated));
    }

    @Override
    public ShapeView createShapeView(ShapeData shapeData, CanvasVM vm) {
        if (!(shapeData instanceof TextInShapeData textInShapeData)) {
            throw new UnsupportedOperationException("Expected TextInShapeData");
        }

        ShapeData decoratedData = textInShapeData.getDecorated();

        ShapeFactory factoryForDecorated = decoratedData.getFactory();
        ShapeView decoratedView = factoryForDecorated.createShapeView(decoratedData, vm);

        return new TextInShapeView(textInShapeData, vm, decoratedView);
    }
}

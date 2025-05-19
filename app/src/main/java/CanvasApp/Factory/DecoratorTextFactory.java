package CanvasApp.Factory;

import CanvasApp.Model.Decorator.TextInShape;
import CanvasApp.Model.ShapeModel;
import CanvasApp.View.ShapeView.Decorator.TextInShapeView;
import CanvasApp.View.ShapeView.ShapeView;
import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.Data.ShapeData.Decorator.TextInShapeData;
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

    public TextInShape createShapeDecorator(ShapeModel shapeModel,String text) {
        return new TextInShape(shapeModel, text);
    }

    @Override
    public ShapeData createShapeData(ShapeModel model) {
        System.out.println("createShapeData - called");

        if (!(model instanceof TextInShape decorator)) {
            System.out.println("createShapeData - unsupported model type: " + model.getClass().getSimpleName());
            throw new UnsupportedOperationException("DecoratorTextFactory supports only DecoratorText");
        }

        ShapeModel decorated = decorator.getDecorated();
        System.out.println("createShapeData - creating ShapeData for decorated model: " + decorated.getClass().getSimpleName());

        ShapeFactory factory = ShapeFactoryRegistry.factoryFor(decorated);
        ShapeData result = new TextInShapeData(decorator, factory.createShapeData(decorated));

        System.out.println("createShapeData - completed");
        return result;
    }

    @Override
    public ShapeView createShapeView(ShapeData data, CanvasVM vm) {
        System.out.println("createShapeView - called");

        if (!(data instanceof TextInShapeData textInShapeData)) {
            System.out.println("createShapeView - unsupported data type: " + data.getClass().getSimpleName());
            throw new UnsupportedOperationException("Expected TextInShapeData");
        }

        ShapeData decoratedData = textInShapeData.getDecorated();
        System.out.println("createShapeView - creating view for decorated data: " + decoratedData.getClass().getSimpleName());

        ShapeFactory factoryForDecorated = decoratedData.getFactory();
        ShapeView decoratedView = factoryForDecorated.createShapeView(decoratedData, vm);

        TextInShapeView result = new TextInShapeView(textInShapeData, vm, decoratedView);
        System.out.println("createShapeView - completed");

        return result;
    }
}

package CanvasApp.Factory;

import CanvasApp.Model.Structure.Composite.Leaf.TextModel;
import CanvasApp.Model.ShapeModel;
import CanvasApp.View.ShapeView.ShapeView;
import CanvasApp.View.ShapeView.TextView;
import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;
import CanvasApp.ViewModel.Data.ShapeData.TextShapeData;

public class TextFactory extends ShapeFactory{
    private static final TextFactory instance = new TextFactory();
    private TextFactory() {}

    public static TextFactory getInstance() {
        return instance;
    }


    @Override
    public ShapeModel createShapeModel(String id, int x, int y, int w, int h, int z) {
        return new TextModel(id, x, y, w, h, z, "text");
    }

    public ShapeModel createShapeModel(String id,int x,int y,int w,int h, int z, String text) {
        return new TextModel(id,x, y, w, h, z, text);
    }

    @Override
    public ShapeData createShapeData(ShapeModel shapeModel) {
        if (!(shapeModel instanceof TextModel textModel)) {
            throw new UnsupportedOperationException("DecoratorTextFactory supports only DecoratorText");
        }
        return new TextShapeData(textModel);
    }

    @Override
    public ShapeView createShapeView(ShapeData shapeData, CanvasVM viewModel) {
        if(!(shapeData instanceof TextShapeData textShapeData)) {
            throw new UnsupportedOperationException("Expected TextShapeData");
        }
        return new TextView(textShapeData, viewModel);
    }
}

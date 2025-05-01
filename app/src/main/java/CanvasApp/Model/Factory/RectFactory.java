package CanvasApp.Model.Factory;

import CanvasApp.Model.Shape.RectangleModel;
import CanvasApp.Model.Shape.ShapeModel;
import CanvasApp.View.ShapeView.RectangleView;
import CanvasApp.View.ShapeView.ShapeView;
import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.ShapeData.ShapeData;

public class RectFactory extends ShapeFactory {
    private static final RectFactory instance = new RectFactory();
    private RectFactory() {}

    public static RectFactory getInstance() {
        return instance;
    }

    @Override
    public ShapeModel createShapeModel(String id, int x, int y, int w, int h, int z) {
        return new RectangleModel(id, x, y, w, h, z);
    }

    @Override
    public ShapeData createShapeData(ShapeModel model) {
        return new ShapeData(model);
    }

    @Override
    public ShapeView createShapeView(ShapeData data, CanvasVM vm) {
        return new RectangleView(data, vm);
    }
}

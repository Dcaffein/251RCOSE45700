package CanvasApp.Factory;

import CanvasApp.Model.Structure.Composite.Leaf.RectModel;
import CanvasApp.Model.ShapeModel;
import CanvasApp.View.ShapeView.RectView;
import CanvasApp.View.ShapeView.ShapeView;
import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

public class RectFactory extends ShapeFactory {
    private static final RectFactory instance = new RectFactory();
    private RectFactory() {}

    public static RectFactory getInstance() {
        return instance;
    }

    @Override
    public ShapeModel createShapeModel(String id, int x, int y, int w, int h, int z) {
        return new RectModel(id, x, y, w, h, z);
    }

    @Override
    public ShapeData createShapeData(ShapeModel shapeModel) {
        return new ShapeData(shapeModel);
    }

    @Override
    public ShapeView createShapeView(ShapeData data, CanvasVM viewModel) {
        return new RectView(data, viewModel);
    }
}

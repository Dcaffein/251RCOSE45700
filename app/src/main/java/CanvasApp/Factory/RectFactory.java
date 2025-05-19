package CanvasApp.Factory;

import CanvasApp.Model.Composite.Leaf.RectModel;
import CanvasApp.Model.Composite.Leaf.ShapeModelLeaf;
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
    public ShapeModelLeaf createShapeModel(String id, int x, int y, int w, int h, int z) {
        return new RectModel(id, x, y, w, h, z);
    }

    @Override
    public ShapeData createShapeData(ShapeModel model) {
        return new ShapeData(model);
    }

    @Override
    public ShapeView createShapeView(ShapeData data, CanvasVM vm) {
        return new RectView(data, vm);
    }
}

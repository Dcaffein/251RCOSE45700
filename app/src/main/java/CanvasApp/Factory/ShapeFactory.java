package CanvasApp.Factory;

import CanvasApp.Model.Shape.Composite.Leaf.ShapeModelLeaf;
import CanvasApp.Model.Shape.ShapeModel;
import CanvasApp.View.ShapeView.ShapeView;
import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.Datas.ShapeData.ShapeData;

import java.util.UUID;

public abstract class ShapeFactory {
    public ShapeModelLeaf createShapeModel(int x, int y, int w, int h, int z) {
        String id = UUID.randomUUID().toString();
        return createShapeModel(id, x, y, w, h, z);
    }

    public abstract ShapeModelLeaf createShapeModel(String id, int x, int y, int w, int h, int z);
    public abstract ShapeData createShapeData(ShapeModel shapeModel);
    public abstract ShapeView createShapeView(ShapeData shapeData, CanvasVM viewModel);
}

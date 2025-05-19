package CanvasApp.Factory;

import CanvasApp.Model.ShapeModel;
import CanvasApp.View.ShapeView.ShapeView;
import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

import java.util.UUID;

public abstract class ShapeFactory {
    public ShapeModel createShapeModel(int x, int y, int w, int h, int z) {
        String id = UUID.randomUUID().toString();
        return createShapeModel(id, x, y, w, h, z);
    }

    public abstract ShapeModel createShapeModel(String id, int x, int y, int w, int h, int z);
    public abstract ShapeData createShapeData(ShapeModel shapeModel);
    public abstract ShapeView createShapeView(ShapeData shapeData, CanvasVM viewModel);
}

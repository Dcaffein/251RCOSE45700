package CanvasApp.Factory;

import CanvasApp.Model.Structure.Composite.Leaf.LineSlashModel;
import CanvasApp.Model.ShapeModel;
import CanvasApp.View.ShapeView.LineSlashView;
import CanvasApp.View.ShapeView.ShapeView;
import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

public class LineSlashFactory extends ShapeFactory {
    private static final LineSlashFactory instance = new LineSlashFactory();

    private LineSlashFactory() {
    }

    public static LineSlashFactory getInstance() {
        return instance;
    }

    @Override
    public ShapeModel createShapeModel(String id, int x, int y, int w, int h, int z) {
        return new LineSlashModel(id, x, y, w, h, z);
    }

    @Override
    public ShapeData createShapeData(ShapeModel shapeModel) {
        return new ShapeData(shapeModel);
    }

    @Override
    public ShapeView createShapeView(ShapeData data, CanvasVM viewModel) {
        return new LineSlashView(data, viewModel);
    }
}

package CanvasApp.Factory;

import CanvasApp.Model.Structure.Composite.Leaf.LineBackSlashModel;
import CanvasApp.Model.ShapeModel;
import CanvasApp.View.ShapeView.LineBackSlashView;
import CanvasApp.View.ShapeView.ShapeView;
import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

public class LineBackSlashFactory extends ShapeFactory {
    private static final LineBackSlashFactory instance = new LineBackSlashFactory();

    private LineBackSlashFactory() {
    }

    public static LineBackSlashFactory getInstance() {
        return instance;
    }

    @Override
    public ShapeModel createShapeModel(String id, int x, int y, int w, int h, int z) {
        return new LineBackSlashModel(id, x, y, w, h, z);
    }

    @Override
    public ShapeData createShapeData(ShapeModel shapeModel) {
        return new ShapeData(shapeModel);
    }

    @Override
    public ShapeView createShapeView(ShapeData data, CanvasVM viewModel) {
        return new LineBackSlashView(data, viewModel);
    }
}

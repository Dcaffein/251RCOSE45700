package CanvasApp.Factory;

import CanvasApp.Model.Structure.Composite.Leaf.TriangleModel;
import CanvasApp.Model.ShapeModel;
import CanvasApp.View.ShapeView.TriangleView;
import CanvasApp.View.ShapeView.ShapeView;
import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

public class TriangleFactory extends ShapeFactory {
  private static final TriangleFactory instance = new TriangleFactory();

  private TriangleFactory() {
  }

  public static TriangleFactory getInstance() {
    return instance;
  }

  @Override
  public ShapeModel createShapeModel(String id, int x, int y, int w, int h, int z) {
    return new TriangleModel(id, x, y, w, h, z);
  }

  @Override
  public ShapeData createShapeData(ShapeModel shapeModel) {
    return new ShapeData(shapeModel);
  }

  @Override
  public ShapeView createShapeView(ShapeData data, CanvasVM viewModel) {
    return new TriangleView(data, viewModel);
  }
}
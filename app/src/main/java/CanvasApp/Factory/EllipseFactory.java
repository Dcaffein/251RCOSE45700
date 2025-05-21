package CanvasApp.Factory;

import CanvasApp.Model.Composite.Leaf.EllipseModel;
import CanvasApp.Model.Composite.Leaf.ShapeModelLeaf;
import CanvasApp.Model.ShapeModel;
import CanvasApp.View.ShapeView.EllipseView;
import CanvasApp.View.ShapeView.ShapeView;
import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

public class EllipseFactory extends ShapeFactory {
  private static final EllipseFactory instance = new EllipseFactory();

  private EllipseFactory() {
  }

  public static EllipseFactory getInstance() {
    return instance;
  }

  @Override
  public ShapeModelLeaf createShapeModel(String id, int x, int y, int w, int h, int z) {
    return new EllipseModel(id, x, y, w, h, z);
  }

  @Override
  public ShapeData createShapeData(ShapeModel shapeModel) {
    return new ShapeData(shapeModel);
  }

  @Override
  public ShapeView createShapeView(ShapeData data, CanvasVM viewModel) {
    return new EllipseView(data, viewModel);
  }
}
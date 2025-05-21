package CanvasApp.Factory;

import CanvasApp.Model.Structure.Composite.Leaf.ImageModel;
import CanvasApp.Model.ShapeModel;
import CanvasApp.View.ShapeView.ImageView;
import CanvasApp.View.ShapeView.ShapeView;
import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

public class ImageFactory extends ShapeFactory {
  private static final ImageFactory instance = new ImageFactory();
  private ImageFactory() {}

  public static ImageFactory getInstance() {
    return instance;
  }

  @Override
  public ShapeModel createShapeModel(String id, int x, int y, int w, int h, int z) {
    return new ImageModel(id, x, y, w, h, z);
  }

  @Override
  public ShapeData createShapeData(ShapeModel shapeModel) {
    return new ShapeData(shapeModel);
  }

  @Override
  public ShapeView createShapeView(ShapeData data, CanvasVM viewModel) {
    return new ImageView(data, viewModel);
  }
}

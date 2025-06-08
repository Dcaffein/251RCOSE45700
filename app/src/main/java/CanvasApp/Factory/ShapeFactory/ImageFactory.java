package CanvasApp.Factory.ShapeFactory;

import CanvasApp.Model.Composite.ConcreteLeaf.ImageModel;
import CanvasApp.Model.ShapeModel;

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
}

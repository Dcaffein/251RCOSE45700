package CanvasApp.Factory.Shape;

import CanvasApp.Model.Composite.ConcreteLeaf.EllipseModel;
import CanvasApp.Model.ShapeModel;

public class EllipseFactory extends ShapeFactory {
  private static final EllipseFactory instance = new EllipseFactory();

  private EllipseFactory() {}

  public static EllipseFactory getInstance() {
    return instance;
  }

  @Override
  public ShapeModel createShapeModel(String id, int x, int y, int w, int h, int z) {
    return new EllipseModel(id, x, y, w, h, z);
  }
}
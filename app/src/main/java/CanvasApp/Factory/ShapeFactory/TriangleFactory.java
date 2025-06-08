package CanvasApp.Factory.ShapeFactory;

import CanvasApp.Model.Composite.ConcreteLeaf.TriangleModel;
import CanvasApp.Model.ShapeModel;

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
}
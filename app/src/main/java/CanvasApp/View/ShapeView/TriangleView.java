package CanvasApp.View.ShapeView;

import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

import java.awt.*;

public class TriangleView extends ConcreteShapeView {

  public TriangleView(ShapeData prop, CanvasVM viewModel) {
    super(prop, viewModel);
  }

  @Override
  public void draw(Graphics g) {
    int padding = shapeData.getPadding();
    int w = shapeData.getW() - 2 * padding;
    int h = shapeData.getH() - 2 * padding;
    int x0 = padding, y0 = padding + h; // 좌하단
    int x1 = padding + w / 2, y1 = padding; // 상단
    int x2 = padding + w, y2 = padding + h; // 우하단

    Polygon tri = new Polygon(new int[] { x0, x1, x2 }, new int[] { y0, y1, y2 }, 3);

    g.drawPolygon(tri);
    g.setColor(new Color(255, 235, 180));
    g.fillPolygon(tri);
  }
}
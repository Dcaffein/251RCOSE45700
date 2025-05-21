package CanvasApp.View.ShapeView;

import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class EllipseView extends ConcreteShapeView {

  public EllipseView(ShapeData prop, CanvasVM viewModel) {
    super(prop, viewModel);
  }

  @Override
  public void draw(Graphics g) {
    int padding = shapeData.getPadding();
    int w = shapeData.getW() - 2 * padding;
    int h = shapeData.getH() - 2 * padding;

    // 외곽선
    g.drawOval(padding, padding, w, h);

    // 내부 채우기
    g.setColor(new Color(200, 255, 200));
    g.fillOval(padding + 1, padding + 1, w - 1, h - 1);
  }

  @Override
  public Shape getShape() {
    int padding = shapeData.getPadding();
    int w = shapeData.getW() - 2 * padding;
    int h = shapeData.getH() - 2 * padding;
    return new Ellipse2D.Double(padding, padding, w, h);
  }

}
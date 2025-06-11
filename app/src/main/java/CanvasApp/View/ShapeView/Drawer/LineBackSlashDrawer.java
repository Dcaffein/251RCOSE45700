package CanvasApp.View.ShapeView.Drawer;

import CanvasApp.View.ShapeView.ShapeView;
import java.awt.*;
import java.awt.geom.Line2D.Double;

public class LineBackSlashDrawer extends Drawer {
    @Override
    public void draw(Graphics g, ShapeView shapeView) {
        int padding = shapeView.viewModel.getPadding();
        int w = shapeView.viewModel.getShape().getW();
        int h = shapeView.viewModel.getShape().getH();
        int multiply = 0;

        g.setColor(Color.BLUE);
        g.drawLine(
          padding * multiply, padding * multiply, w - padding * multiply, h - padding * multiply
        );
    }

    @Override
    public Shape getShape(ShapeView shapeView) {
        int padding = shapeView.viewModel.getPadding();
        int w = shapeView.viewModel.getShape().getW();
        int h = shapeView.viewModel.getShape().getH();
        int multiply = 0;

        return new Double(padding * multiply, padding * multiply, w - padding * multiply, h - padding * multiply);
    }
}

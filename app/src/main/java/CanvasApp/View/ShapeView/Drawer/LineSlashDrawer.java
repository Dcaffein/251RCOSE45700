package CanvasApp.View.ShapeView.Drawer;

import CanvasApp.View.ShapeView.ShapeView;
import java.awt.*;
import java.awt.geom.Line2D.Double;

public class LineSlashDrawer extends Drawer {
    @Override
    public void draw(Graphics g, ShapeView shapeView) {
        int padding = shapeView.viewModel.getPadding();
        int w = shapeView.viewModel.getShape().getW();
        int h = shapeView.viewModel.getShape().getH();
        int multiply = 0;

        g.setColor(Color.BLUE);
        g.drawLine(
          padding * multiply, h - padding * multiply,  w - padding * multiply, padding * multiply
        );
    }

    @Override
    public Shape getShape(ShapeView shapeView) {
        int padding = shapeView.viewModel.getPadding();
        int w = shapeView.viewModel.getShape().getW();
        int h = shapeView.viewModel.getShape().getH();
        int multiply = 0;

        return new Double(
            // offset by getPadding
            padding * multiply + padding,
            h - padding * multiply + padding,
            w - padding * multiply + padding,
            padding * multiply + padding
        );
    }
}

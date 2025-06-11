package CanvasApp.View.ShapeView.Drawer;

import CanvasApp.View.ShapeView.ShapeView;
import java.awt.*;
import java.awt.geom.Ellipse2D.Double;

public class EllipseDrawer extends Drawer {
    @Override
    public void draw(Graphics g, ShapeView shapeView) {
        int padding = shapeView.viewModel.getPadding();
        int w = shapeView.viewModel.getShape().getW();
        int h = shapeView.viewModel.getShape().getH();

        g.drawOval(padding, padding, w - 2*padding, h - 2*padding);
        g.setColor(new Color(200, 220, 255));
        g.fillOval(padding+1, padding+1, w - 3 *padding, h - 3 *padding);
    }

    @Override
    public Shape getShape(ShapeView shapeView) {
        int padding = shapeView.viewModel.getPadding();
        int w = shapeView.viewModel.getShape().getW();
        int h = shapeView.viewModel.getShape().getH();

        return new Double(padding,padding,w - 4 * padding,h - 4* padding);
    }
}

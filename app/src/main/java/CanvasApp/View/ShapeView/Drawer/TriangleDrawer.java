package CanvasApp.View.ShapeView.Drawer;

import CanvasApp.View.ShapeView.ShapeView;
import java.awt.*;

public class TriangleDrawer extends Drawer {
    @Override
    public void draw(Graphics g, ShapeView shapeView) {
        g.setColor(Color.BLUE);
        g.drawPolygon(getOwnPolygon(shapeView, 2));
        g.setColor(new Color(200, 220, 255));
        g.fillPolygon(getOwnPolygon(shapeView, 2));
    }

    @Override
    public Shape getShape(ShapeView shapeView) {
        return getOwnPolygon(shapeView, 0);
    }
    
    private Polygon getOwnPolygon(ShapeView shapeView, int multiply) {
        int padding = shapeView.viewModel.getPadding();
        int w = shapeView.viewModel.getShape().getW();
        int h = shapeView.viewModel.getShape().getH();

        // Define width and height after padding
        int x1 = padding * multiply;
        int y1 = h - padding * multiply;

        int x2 = w - padding * multiply;
        int y2 = h - padding * multiply;

        int x3 = w / 2;
        int y3 = padding * multiply;

        return new Polygon(new int[] { x1, x2, x3 }, new int[] { y1, y2, y3 }, 3);
    }
}

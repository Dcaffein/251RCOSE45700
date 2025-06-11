package CanvasApp.View.ShapeView.Drawer;

import CanvasApp.View.ShapeView.ShapeView;
import java.awt.*;

public class TriangleDrawer extends Drawer {
    @Override
    public void draw(Graphics g, ShapeView shapeView) {
        int padding = shapeView.viewModel.getPadding();
        int w = shapeView.viewModel.getShape().getW();
        int h = shapeView.viewModel.getShape().getH();

        // Set triangle color
        g.setColor(Color.BLUE);

        // Define width and height after padding
        int x1 = padding;
        int y1 = h - padding;

        int x2 = w - padding;
        int y2 = h - padding;

        int x3 = w / 2;
        int y3 = padding;

        // Draw triangle outline
        g.drawPolygon(new int[]{x1, x2, x3}, new int[]{y1, y2, y3}, 3);

        g.setColor(new Color(200, 220, 255));
        g.fillPolygon(
            new int[]{x1 + 1, x2 - 1, x3},
            new int[]{y1 - 1, y2 - 1, y3 + 1},
            3
        );
    }

    @Override
    public Shape getShape(ShapeView shapeView) {
        int padding = shapeView.viewModel.getPadding();
        int w = shapeView.viewModel.getShape().getW();
        int h = shapeView.viewModel.getShape().getH();

        return new Rectangle(0,0,w,h);
    }
}

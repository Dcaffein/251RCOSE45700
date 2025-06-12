package CanvasApp.View.ShapeView.Drawer;

import CanvasApp.View.ShapeView.ShapeView;

import java.awt.*;

public class TextDrawer extends Drawer{
    @Override
    public void draw(Graphics g, ShapeView shapeView) {
        int padding = shapeView.viewModel.getPadding();
        int w = shapeView.viewModel.getShape().getW();
        int h = shapeView.viewModel.getShape().getH();

        g.drawRect(padding, padding, w - 2*padding, h - 2*padding);
    }

    @Override
    public Shape getShape(ShapeView shapeView) {
        int padding = shapeView.viewModel.getPadding();
        int w = shapeView.viewModel.getShape().getW();
        int h = shapeView.viewModel.getShape().getH();

        return new Rectangle(0,0,w,h);
    }
}

package CanvasApp.View.ShapeView.Drawer;

import CanvasApp.ViewModel.ShapeViewModel.ShapeViewModel;

import java.awt.*;

public class RectDrawer implements Drawer{
    @Override
    public void draw(Graphics g, ShapeViewModel viewModel) {
        int padding = viewModel.padding;

        int w = viewModel.shape.getW();
        int h = viewModel.shape.getH();

        g.drawRect(padding, padding, w - 2*padding, h - 2*padding);
        g.setColor(new Color(200, 220, 255));
        g.fillRect(padding+1, padding+1, w - 3*padding, h - 3*padding);
    }
}

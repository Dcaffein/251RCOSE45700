package CanvasApp.View.ShapeView.Drawer;

import CanvasApp.ViewModel.ShapeViewModel.ShapeViewModel;

import java.awt.*;

public interface Drawer {
    void draw(Graphics g, ShapeViewModel viewModel);
}

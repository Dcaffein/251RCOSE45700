package CanvasApp.View.ShapeView;

import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

import java.awt.*;

public class LineBackSlashView extends ConcreteShapeView {
    public LineBackSlashView(ShapeData prop, CanvasVM viewModel) {
        super(prop, viewModel);
    }

    @Override
    public void draw(Graphics g) {
        int padding = shapeData.getPadding();
        int w = shapeData.getW();
        int h = shapeData.getH();

        g.setColor(new Color(200, 220, 255));
        g.drawLine(padding, padding, w - 2 * padding, h - 2 * padding);
    }
}

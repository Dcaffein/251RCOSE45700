package CanvasApp.View.ShapeView;

import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

import java.awt.*;
import java.awt.geom.Line2D;

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

    @Override
    public Shape getShape() {
        int padding = shapeData.getPadding();
        int w = shapeData.getW() - 2 * padding;
        int h = shapeData.getH() - 2 * padding;
        return new Line2D.Double(padding, padding, w - 2 * padding, h - 2 * padding);
    }
}

package CanvasApp.View.ShapeView;

import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.ShapeData.ReadOnlyShapeData;

import java.awt.*;

public class RectangleView extends ShapeView {
    public RectangleView(ReadOnlyShapeData prop, CanvasVM viewModel) {
        super(prop, viewModel);
    }

    @Override public void draw(Graphics g){
        int padding = shapeData.getPadding();
        int w = shapeData.getW();
        int h = shapeData.getH();

        g.drawRect(padding, padding, w - 2*padding, h - 2*padding);
        g.setColor(new Color(200, 220, 255));
        g.fillRect(padding+1, padding+1, w - 3*padding, h - 3*padding);
    }

}

package CanvasApp.View.ShapeView.Drawer;

import CanvasApp.Model.Decorator.Shadow;
import CanvasApp.Model.ShapeModel;
import CanvasApp.View.ShapeView.ShapeView;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class ShadowDrawer extends Drawer {
    @Override
    public void draw(Graphics g, ShapeView shapeView) {
        ShapeModel shapeModel = shapeView.viewModel.getShape();
        if(shapeModel instanceof Shadow shadow) {
            Shape shape = getShape(shapeView);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(new Color(shadow.getColor()));
            AffineTransform tx = AffineTransform.getTranslateInstance(shadow.getBorder(), shadow.getBorder());
            Shape shadowed = tx.createTransformedShape(shape);
            g2d.fill(shadowed);
        }

        decorated.draw(g, shapeView);
    }

    @Override
    public Shape getShape(ShapeView shapeView) {
        return decorated.getShape(shapeView);
    }
}

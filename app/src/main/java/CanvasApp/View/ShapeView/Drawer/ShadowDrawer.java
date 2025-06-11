package CanvasApp.View.ShapeView.Drawer;

import CanvasApp.Model.Decorator.Shadow;
import CanvasApp.Model.Decorator.ShapeDecorator;
import CanvasApp.Model.ShapeModel;
import CanvasApp.View.ShapeView.ShapeView;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class ShadowDrawer extends Drawer {
    @Override
    public void draw(Graphics g, ShapeView shapeView) {
        ShapeModel shapeModel = shapeView.viewModel.getShape();

        if (shapeModel instanceof ShapeDecorator d && d.getDecorator(Shadow.class) instanceof Shadow shadow) {
            Graphics2D g2d = (Graphics2D) g.create();
            try {
                Shape shape = getShape(shapeView);
                g2d.setColor(new Color(shadow.getColor()));

                AffineTransform tx = AffineTransform.getTranslateInstance(shadow.getBorder(), shadow.getBorder());
                Shape shadowedShape = tx.createTransformedShape(shape);
                g2d.fill(shadowedShape);
            } finally {
                g2d.dispose();
            }
        }

        decorated.draw(g, shapeView);
    }

    @Override
    public Shape getShape(ShapeView shapeView) {
        return decorated.getShape(shapeView);
    }
}

package CanvasApp.View.ShapeView.Decorator.Shadow;

import CanvasApp.View.ShapeView.Decorator.ShapeViewDecorator;
import CanvasApp.View.ShapeView.ShapeView;
import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.Data.ShapeData.Decorator.Shadow.ShadowData;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class ShadowAroundShapeView extends ShapeViewDecorator {
    private int shadowOffset = 5;
    private ShadowData shadowData;

    public ShadowAroundShapeView(ShadowData shapeData, CanvasVM viewModel, ShapeView decorated) {
        super(shapeData, viewModel, decorated);
        this.shadowData = shapeData;
    }

    @Override
    public void paintComponent(Graphics g) {
        draw(g);
    }

    @Override
    public void addNotify() {
        super.addNotify();
    }


    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create(); // 원본 보호용 복사

        g2.setColor(shadowData.getColor());
        Shape shape = getShape();
        if(shape != null) {return;}
        AffineTransform tx = AffineTransform.getTranslateInstance(shadowOffset, shadowOffset);
        Shape shadow = tx.createTransformedShape(shape);
        g2.fill(shadow);

        decorated.draw(g);

        g2.dispose();
    }
}

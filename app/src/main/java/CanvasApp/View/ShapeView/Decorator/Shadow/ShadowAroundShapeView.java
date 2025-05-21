package CanvasApp.View.ShapeView.Decorator.Shadow;

import CanvasApp.View.ShapeView.Decorator.ShapeViewDecorator;
import CanvasApp.View.ShapeView.ShapeView;
import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.Data.ShapeData.Decorator.Shadow.ShadowData;

import java.awt.*;

public class ShadowAroundShapeView extends ShapeViewDecorator {
    private int shadowOffset = 15;
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
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create(); // 원본 보호용 복사

        int x =  shadowOffset;
        int y =  shadowOffset;

        int w = shadowData.getW();
        int h = shadowData.getH();

        g2.setColor(shadowData.getColor());
        g2.fillRoundRect(x, y, w, h, 10, 10);

        decorated.draw(g);

        g2.dispose();
    }
}

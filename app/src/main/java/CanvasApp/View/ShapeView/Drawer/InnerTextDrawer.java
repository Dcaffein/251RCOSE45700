package CanvasApp.View.ShapeView.Drawer;

import CanvasApp.Model.Decorator.InnerText;
import CanvasApp.Model.Decorator.ShapeDecorator;
import CanvasApp.Model.ShapeModel;
import CanvasApp.View.ShapeView.ShapeView;

import java.awt.*;

public class InnerTextDrawer extends Drawer {
    @Override
    public void draw(Graphics g, ShapeView shapeView) {
        ShapeModel shapeModel = shapeView.viewModel.getShape();

        decorated.draw(g, shapeView);

        if (shapeModel instanceof ShapeDecorator d && d.getDecorator(InnerText.class) instanceof InnerText innerText) {
            Graphics2D g2d = (Graphics2D) g.create();
            try {
                String text = innerText.getText();
                if (text != null && !text.isEmpty()) {
                    Shape shape = getShape(shapeView);
                    Rectangle bounds = shape.getBounds();

                    Font font = new Font("SansSerif", Font.PLAIN, 14);
                    g2d.setFont(font);
                    FontMetrics fm = g2d.getFontMetrics();
                    int textWidth = fm.stringWidth(text);
                    int textHeight = fm.getAscent();

                    int x = bounds.x + (bounds.width - textWidth) / 2;
                    int y = bounds.y + (bounds.height + textHeight) / 2 - fm.getDescent();

                    g2d.setColor(Color.BLACK);
                    g2d.drawString(text, x, y);
                }
            } finally {
                g2d.dispose();
            }
        }
    }

    @Override
    public Shape getShape(ShapeView shapeView) {
        return decorated.getShape(shapeView);
    }
}

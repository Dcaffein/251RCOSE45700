package CanvasApp.View.ShapeView;

import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Optional;

import javax.imageio.ImageIO;

public class ImageView extends ConcreteShapeView {
    public ImageView(ShapeData prop, CanvasVM viewModel) {
        super(prop, viewModel);
    }

    @Override
    public void draw(Graphics g) {
        int p = shapeData.getPadding();
        g.setColor(new Color(200, 220, 255));
        loadImage().map(data -> {
            System.out.println("printing image");
            return g.drawImage(
                    data,
                    p, p,
                    shapeData.getW() - 2 * p,
                    shapeData.getH() - 2 * p,
                    null);
        });
    }

    @Override
    public Shape getShape() {
        int padding = shapeData.getPadding();
        int w = shapeData.getW() - 2 * padding;
        int h = shapeData.getH() - 2 * padding;
        return new Rectangle(padding, padding, w, h);
    }

    private Optional<BufferedImage> loadImage() {
        String resource = "/sample.jpg";
        try {
            return Optional.of(ImageIO.read(getClass().getResource(resource)));
        } catch (IOException e) {
            return Optional.empty();
        }
    }

}

package Canvas.View;

import Canvas.ViewModel.CanvasVM;
import Canvas.ViewModel.ShapeProp;

import javax.swing.*;
import java.util.Random;

public class CanvasView extends JPanel {
    private final CanvasVM viewModel;
    private final JButton rectButton = new JButton("Create Rectangle");
    private final Random random = new Random();

    private final JLayeredPane layeredPane = new JLayeredPane();

    public CanvasView(CanvasVM viewModel) {
        this.viewModel = viewModel;
        setLayout(null);
        initUI();
    }

    private void initUI() {
        layeredPane.setBounds(0, 0, 800, 600);
        layeredPane.setLayout(null);
        this.add(layeredPane);

        rectButton.setBounds(10, 10, 150, 30);
        rectButton.addActionListener(e -> createRect());
        this.add(rectButton);
    }

    private void createRect() {
        int maxX = 800 - 100;
        int maxY = 600 - 100;
        int randomX = random.nextInt(maxX);
        int randomY = random.nextInt(maxY);
        int initialW = 100;
        int initialH = 100;
        int initialZ = random.nextInt(100);

        ShapeProp rectViewProps = viewModel.createShape(randomX,randomY,initialW,initialH,initialZ);
        ShapeViewComponent component = new RectangleView(rectViewProps, viewModel);
        rectViewProps.attachView(component);

        component.setBounds(randomX, randomY, initialW, initialH);
        layeredPane.add(component, Integer.valueOf(initialZ));
    }
}

package Canvas.View;

import Canvas.Domain.Command.ShapeCommand.CreateShape.CreateRectCommand;
import Canvas.ViewModel.CanvasVM;

import javax.swing.*;
import java.util.Random;

public class CanvasView extends JPanel {
    private final CanvasVM viewModel;
    private final JButton rectButton = new JButton("Create Rectangle");
    private final Random random = new Random();

    public CanvasView(CanvasVM viewModel) {
        this.viewModel = viewModel;
        setLayout(null);
        initUI();
    }

    private void initUI() {
        rectButton.setBounds(10, 10, 100, 30);
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
        int initialZ = 0;
        CreateRectCommand command = new CreateRectCommand(viewModel,randomX,randomY,initialW,initialH,initialZ);
        String id = viewModel.createShape(command);
        ShapeViewComponent component = new ShapeViewComponent(id, viewModel);
        viewModel.get(id).attach(component);
        component.setBounds(randomX, randomY, initialW, initialH);
        add(component);
        revalidate();
        repaint();
    }
}
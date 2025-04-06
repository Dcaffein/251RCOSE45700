package Canvas.View;

import Canvas.Domain.Command.ShapeCommand.CreateShapeCommand.CreateRectCommand;
import Canvas.ViewModel.CanvasVM;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CanvasView extends JPanel {
    private final CanvasVM viewModel;
    private final JButton rectButton = new JButton("Create Rectangle");

    public CanvasView(CanvasVM viewModel) {
        this.viewModel = viewModel;
        setLayout(null);
        initUI();
    }


    private void initUI() {
        rectButton.setBounds(10, 10, 150, 30); // ✅ 버튼의 위치와 크기 지정
        rectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createRect();
            }
        });
        this.add(rectButton);
    }


    private void createRect() {
        CreateRectCommand command = new CreateRectCommand(viewModel);
        String id = viewModel.createShape(command);

        ShapeViewComponent component = new ShapeViewComponent(id, viewModel);
        viewModel.get(id).attach(component);
        add(component);
        revalidate();
        repaint();
    }
}
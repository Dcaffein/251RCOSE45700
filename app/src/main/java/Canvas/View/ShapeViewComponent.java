package Canvas.View;

import Canvas.Domain.Observer.Observer;
import Canvas.ViewModel.CanvasVM;

import javax.swing.JComponent;
import java.awt.*;

public class ShapeViewComponent extends JComponent implements Observer {
    private final String id;
    private final CanvasVM viewModel;

    public ShapeViewComponent(String id, CanvasVM viewModel) {
        this.id = id;
        this.viewModel = viewModel;
        setBounds(viewModel.getX(id), viewModel.getY(id), viewModel.getW(id),viewModel.getH(id));
    }

    @Override
    public void onUpdate(Object obj) {
        if (obj != null && obj.toString().equals(id)) {
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        viewModel.draw(g, id);
    }
}

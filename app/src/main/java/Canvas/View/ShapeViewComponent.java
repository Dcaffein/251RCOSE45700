package Canvas.View;

import Canvas.Domain.Command.ShapeCommand.RenderShape.ShapeObjectEvent;
import Canvas.Domain.Observer.ShapeObjectObserver;
import Canvas.ViewModel.CanvasVM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class ShapeViewComponent extends JComponent implements ShapeObjectObserver {
    private final String id;
    private final CanvasVM viewModel;

    private Point dragStart = null;

    public ShapeViewComponent(String id, CanvasVM viewModel ) {
        this.id = id;
        this.viewModel = viewModel;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                requestFocusInWindow();
                if (e.isControlDown()) {
                    viewModel.handleSelected(id);
                } else {
                    viewModel.deSelectAll();
                    viewModel.handleSelected(id);
                }
                dragStart = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                dragStart = null;
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (dragStart == null) return;

                Point dragEnd = e.getPoint();
                int dx = dragEnd.x - dragStart.x;
                int dy = dragEnd.y - dragStart.y;

                System.out.printf("[Mouse Dragged] dx=%d, dy=%d\n", dx, dy);
                viewModel.move(dx, dy);
                dragStart = dragEnd;
            }
        });
    }

    @Override
    public void onUpdate(ShapeObjectEvent event) {
        if(event.targetId.equals(id)) {
            event.apply(this);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        viewModel.draw(g,id);
    }
}

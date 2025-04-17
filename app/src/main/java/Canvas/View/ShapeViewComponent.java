package Canvas.View;

import Canvas.Domain.Observer.ShapeObjectEvent;
import Canvas.Domain.Observer.ShapeObjectObserver;
import Canvas.ViewModel.CanvasVM;
import Canvas.ViewModel.ReadOnlyShapeProp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public abstract class ShapeViewComponent extends JComponent implements ShapeObjectObserver {
    protected final ReadOnlyShapeProp shapeProp;
    protected final CanvasVM viewModel;

    protected Point dragStart = null;

    public ShapeViewComponent(ReadOnlyShapeProp shapeProp, CanvasVM viewModel ) {
        this.shapeProp = shapeProp;
        this.viewModel = viewModel;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                if (e.isControlDown()) {
                    viewModel.multiSelect(shapeProp.getId());
                } else {
                    viewModel.select(shapeProp.getId());
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
        int x = shapeProp.getX(), y = shapeProp.getY();
        int w = shapeProp.getW(), h = shapeProp.getH();
        setBounds(x, y, w, h);
        repaint();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public abstract void draw(Graphics g);

}

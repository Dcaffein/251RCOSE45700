package Canvas.Domain.Command.ShapeCommand.RenderShape;

import javax.swing.*;

public class Resized extends ShapeObjectEvent {
    public final int x, y, w, h;

    public Resized(String targetId, int x, int y, int w, int h) {
        super(targetId);
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    @Override
    public void apply(JComponent view) {
        view.setBounds(x, y, w, h);
        view.repaint();
    }
}

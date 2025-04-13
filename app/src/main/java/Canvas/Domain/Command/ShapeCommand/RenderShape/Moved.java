package Canvas.Domain.Command.ShapeCommand.RenderShape;

import javax.swing.JComponent;

public class Moved extends ShapeObjectEvent {
    public final int x, y, w, h;

    public Moved(String targetId, int x, int y, int w, int h) {
        super(targetId);
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    @Override
    public void apply(JComponent view) {
        view.setBounds(x, y, w, h);
        System.out.printf("[Apply Bounds] id=%s → x=%d, y=%d, w=%d, h=%d\n",
                view.getName(), x, y, w, h);
    }
}

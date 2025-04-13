package Canvas.Domain.Command.ShapeCommand.RenderShape;

import javax.swing.JComponent;

public abstract class ShapeObjectEvent {
    public final String targetId;

    public ShapeObjectEvent(String targetId) {
        this.targetId = targetId;
    }

    public abstract void apply(JComponent view);
}
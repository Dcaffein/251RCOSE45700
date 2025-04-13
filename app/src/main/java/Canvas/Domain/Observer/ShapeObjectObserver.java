package Canvas.Domain.Observer;

import Canvas.Domain.Command.ShapeCommand.RenderShape.ShapeObjectEvent;

public interface ShapeObjectObserver {
    void onUpdate(ShapeObjectEvent event);
}

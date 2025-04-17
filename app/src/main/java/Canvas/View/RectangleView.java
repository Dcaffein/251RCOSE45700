package Canvas.View;

import Canvas.ViewModel.CanvasVM;
import Canvas.ViewModel.ReadOnlyShapeProp;
import java.awt.Graphics;

public class RectangleView extends ShapeViewComponent {
    public RectangleView(ReadOnlyShapeProp prop, CanvasVM viewModel) {
        super(prop, viewModel);
    }

    @Override public void draw(Graphics g){
        g.drawRect(shapeProp.getPadding(), shapeProp.getPadding(), shapeProp.getW()-2* shapeProp.getPadding(), shapeProp.getH()-2* shapeProp.getPadding());
    }
}

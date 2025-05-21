package CanvasApp.View.ShapeView.Decorator.Text.Strategy;

import CanvasApp.View.ShapeView.Decorator.Text.StrategyTextInShapeView;
import CanvasApp.View.ShapeView.Decorator.Text.TextInViewHandler;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataEvent;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataResized;

public class HandleResized extends StrategyTextInShapeView {
    public HandleResized(TextInViewHandler textInViewHandler) {
        super(textInViewHandler);
    }

    @Override
    public void handle(ShapeDataEvent event) {
        if(event instanceof ShapeDataResized e){
//            ShapeData shapeData = e.source;
//            TextInShapeView view = textInViewHandler.textInShapeView;
//            view.setBounds(shapeData.getX(),shapeData.getY(),shapeData.getW(),shapeData.getH());
//            view.repaint();
        }
    }
}

package CanvasApp.View.ShapeView.Decorator.Strategy;

import CanvasApp.View.ShapeView.Decorator.StrategyTextInShapeView;
import CanvasApp.View.ShapeView.Decorator.TextInShapeView;
import CanvasApp.View.ShapeView.Decorator.TextInViewHandler;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataEvent;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataResized;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

public class HandleTextChanged extends StrategyTextInShapeView {
    public HandleTextChanged(TextInViewHandler textInViewHandler) {
        super(textInViewHandler);
    }

    @Override
    public void handle(ShapeDataEvent event) {
        if(event instanceof ShapeDataResized e){
            ShapeData shapeData = e.source;
            TextInShapeView view = textInViewHandler.textInShapeView;
            view.setBounds(shapeData.getX(),shapeData.getY(),shapeData.getW(),shapeData.getH());
            view.repaint();
        }
    }
}

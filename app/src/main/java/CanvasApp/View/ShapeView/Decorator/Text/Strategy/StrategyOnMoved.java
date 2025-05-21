package CanvasApp.View.ShapeView.Decorator.Text.Strategy;

import CanvasApp.View.ShapeView.Decorator.Text.StrategyHandlingTextInShapeView;
import CanvasApp.View.ShapeView.Decorator.Text.TextInShapeViewHandler;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataEvent;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataMoved;

public class StrategyOnMoved extends StrategyHandlingTextInShapeView {
    public StrategyOnMoved(TextInShapeViewHandler textInShapeViewHandler) {
        super(textInShapeViewHandler);
    }

    @Override
    public void handle(ShapeDataEvent event) {
        if(event instanceof ShapeDataMoved e){
//            ShapeData shapeData = e.source;
//            TextInShapeView view = textInViewHandler.textInShapeView;
//            view.setBounds(shapeData.getX(),shapeData.getY(),shapeData.getW(),shapeData.getH());
        }
    }
}

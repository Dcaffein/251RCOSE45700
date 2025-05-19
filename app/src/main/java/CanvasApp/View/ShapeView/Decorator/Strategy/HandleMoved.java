package CanvasApp.View.ShapeView.Decorator.Strategy;

import CanvasApp.View.ShapeView.Decorator.StrategyTextInShapeView;
import CanvasApp.View.ShapeView.Decorator.TextInShapeView;
import CanvasApp.View.ShapeView.Decorator.TextInViewHandler;
import CanvasApp.ViewModel.Data.ShapeData.Decorator.TextInShapeData;
import CanvasApp.ViewModel.Data.ShapeData.Decorator.TextInShapeDataChanged;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataEvent;

public class HandleMoved extends StrategyTextInShapeView {
    public HandleMoved(TextInViewHandler textInViewHandler) {
        super(textInViewHandler);
    }

    @Override
    public void handle(ShapeDataEvent event) {
        if(event instanceof TextInShapeDataChanged e){
            String text = ((TextInShapeData) e.source).getText();
            TextInShapeView view = textInViewHandler.textInShapeView;
            view.updateTextDisplay(text);
        }
    }
}

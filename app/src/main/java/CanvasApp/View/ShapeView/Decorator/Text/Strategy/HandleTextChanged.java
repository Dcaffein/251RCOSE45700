package CanvasApp.View.ShapeView.Decorator.Text.Strategy;

import CanvasApp.View.ShapeView.Decorator.Text.StrategyTextInShapeView;
import CanvasApp.View.ShapeView.Decorator.Text.TextInShapeView;
import CanvasApp.View.ShapeView.Decorator.Text.TextInViewHandler;
import CanvasApp.ViewModel.Data.ShapeData.Decorator.TextInShapeData;
import CanvasApp.ViewModel.Data.ShapeData.Decorator.TextInShapeDataChanged;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataEvent;

public class HandleTextChanged extends StrategyTextInShapeView {
    public HandleTextChanged(TextInViewHandler textInViewHandler) {
        super(textInViewHandler);
    }

    @Override
    public void handle(ShapeDataEvent event) {
        if(event instanceof TextInShapeDataChanged e){
            System.out.println("[TextInShapeDataChanged] source : " + e.source);
            String text = ((TextInShapeData) e.source).getText();
            TextInShapeView view = textInViewHandler.textInShapeView;
            view.updateTextDisplay(text);
        }
    }
}

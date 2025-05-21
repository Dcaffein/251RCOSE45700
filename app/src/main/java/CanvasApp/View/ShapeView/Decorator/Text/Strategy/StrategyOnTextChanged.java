package CanvasApp.View.ShapeView.Decorator.Text.Strategy;

import CanvasApp.View.ShapeView.Decorator.Text.StrategyHandlingTextInShapeView;
import CanvasApp.View.ShapeView.Decorator.Text.TextInShapeView;
import CanvasApp.View.ShapeView.Decorator.Text.TextInShapeViewHandler;
import CanvasApp.ViewModel.Data.ShapeData.Decorator.Text.TextInShapeData;
import CanvasApp.ViewModel.Data.ShapeData.Decorator.Text.TextInShapeDataChanged;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataEvent;

public class StrategyOnTextChanged extends StrategyHandlingTextInShapeView {
    public StrategyOnTextChanged(TextInShapeViewHandler textInShapeViewHandler) {
        super(textInShapeViewHandler);
    }

    @Override
    public void handle(ShapeDataEvent event) {
        if(event instanceof TextInShapeDataChanged e){
            System.out.println("[TextInShapeDataChanged] source : " + e.source);
            String text = ((TextInShapeData) e.source).getText();
            TextInShapeView view = textInShapeViewHandler.textInShapeView;
            view.updateTextDisplay(text);
        }
    }
}

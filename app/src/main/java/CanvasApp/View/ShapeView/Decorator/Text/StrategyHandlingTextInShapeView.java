package CanvasApp.View.ShapeView.Decorator.Text;

import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataEvent;
import Observer.EventHandlingStrategy;

public abstract class StrategyHandlingTextInShapeView implements EventHandlingStrategy<ShapeDataEvent> {
    public TextInShapeViewHandler textInShapeViewHandler;

    public StrategyHandlingTextInShapeView(TextInShapeViewHandler textInShapeViewHandler) {
        this.textInShapeViewHandler = textInShapeViewHandler;
    }
}

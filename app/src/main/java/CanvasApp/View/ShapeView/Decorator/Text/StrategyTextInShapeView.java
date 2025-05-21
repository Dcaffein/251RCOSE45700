package CanvasApp.View.ShapeView.Decorator.Text;

import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataEvent;
import Observer.EventHandlingStrategy;

public abstract class StrategyTextInShapeView implements EventHandlingStrategy<ShapeDataEvent> {
    public TextInViewHandler textInViewHandler;

    public StrategyTextInShapeView(TextInViewHandler textInViewHandler) {
        this.textInViewHandler = textInViewHandler;
    }
}

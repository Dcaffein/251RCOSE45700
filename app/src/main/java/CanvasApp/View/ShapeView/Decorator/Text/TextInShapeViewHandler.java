package CanvasApp.View.ShapeView.Decorator.Text;

import CanvasApp.View.ShapeView.Decorator.Text.Strategy.StrategyOnTextChanged;
import CanvasApp.ViewModel.Data.ShapeData.Decorator.Text.TextInShapeDataChanged;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataEvent;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataObserver;

import java.util.HashMap;
import java.util.Map;

public class TextInShapeViewHandler implements ShapeDataObserver {
    public final TextInShapeView textInShapeView;
    private final Map<Class<? extends ShapeDataEvent>, StrategyHandlingTextInShapeView> strategies = new HashMap<>();

    public TextInShapeViewHandler(TextInShapeView textInShapeView) {
        this.textInShapeView = textInShapeView;
        initializeStrategies();
    }

    private void initializeStrategies() {
        strategies.put(TextInShapeDataChanged.class, new StrategyOnTextChanged(this));
    }

    @Override
    public void onUpdate(ShapeDataEvent shapeDataEvent) {
        if (shapeDataEvent.source != textInShapeView.getShapeData()) {
            return;
        }
        StrategyHandlingTextInShapeView strategy = strategies.get(shapeDataEvent.getClass());
        if (strategy != null) {
            strategy.handle(shapeDataEvent);
        }
    }
}

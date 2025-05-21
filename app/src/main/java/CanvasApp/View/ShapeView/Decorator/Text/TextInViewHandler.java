package CanvasApp.View.ShapeView.Decorator.Text;

import CanvasApp.View.ShapeView.Decorator.Text.Strategy.HandleTextChanged;
import CanvasApp.ViewModel.Data.ShapeData.Decorator.TextInShapeDataChanged;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataEvent;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataObserver;

import java.util.HashMap;
import java.util.Map;

public class TextInViewHandler implements ShapeDataObserver {
    public final TextInShapeView textInShapeView;
    private final Map<Class<? extends ShapeDataEvent>, StrategyTextInShapeView> strategies = new HashMap<>();

    public TextInViewHandler(TextInShapeView textInShapeView) {
        this.textInShapeView = textInShapeView;
        initializeStrategies();
    }

    private void initializeStrategies() {
        strategies.put(TextInShapeDataChanged.class, new HandleTextChanged(this));
    }

    @Override
    public void onUpdate(ShapeDataEvent shapeDataEvent) {
        if (shapeDataEvent.source != textInShapeView.getShapeData()) {
            return;
        }
        StrategyTextInShapeView strategy = strategies.get(shapeDataEvent.getClass());
        if (strategy != null) {
            strategy.handle(shapeDataEvent);
        }
    }
}

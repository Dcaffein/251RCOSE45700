package CanvasApp.View.ShapeView.Decorator;

import CanvasApp.View.ShapeView.Decorator.Strategy.HandleMoved;
import CanvasApp.View.ShapeView.Decorator.Strategy.HandleResized;
import CanvasApp.View.ShapeView.Decorator.Strategy.HandleTextChanged;
import CanvasApp.ViewModel.Data.ShapeData.Decorator.TextInShapeDataChanged;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataEvent;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataMoved;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataObserver;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataResized;

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
//        strategies.put(TextInShapeDataChanged.class, new HandleTextChanged(this));
//        strategies.put(ShapeDataMoved.class, new HandleMoved(this));
//        strategies.put(ShapeDataResized.class, new HandleResized(this));
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

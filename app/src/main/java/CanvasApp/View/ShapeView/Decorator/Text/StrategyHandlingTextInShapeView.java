package CanvasApp.View.ShapeView.Decorator.Text;

import CanvasApp.Model.Structure.HasText;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataEvent;
import Observer.EventHandlingStrategy;

public abstract class StrategyHandlingTextInShapeView implements EventHandlingStrategy<ShapeDataEvent> {
    public HasText context;

    public StrategyHandlingTextInShapeView(HasText context) {
        this.context = context;
    }
}

package CanvasApp.View.ShapeView.Decorator.Text.Strategy;

import CanvasApp.Model.Structure.HasText;
import CanvasApp.View.ShapeView.Decorator.Text.StrategyHandlingTextInShapeView;
import CanvasApp.View.ShapeView.Decorator.Text.TextInShapeView;
import CanvasApp.View.ShapeView.Decorator.Text.TextInShapeViewHandler;
import CanvasApp.ViewModel.Data.ShapeData.Decorator.Text.TextInShapeData;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataTextChanged;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataEvent;

public class StrategyOnTextChanged extends StrategyHandlingTextInShapeView {
    public StrategyOnTextChanged(HasText context) {
        super(context);
    }

    @Override
    public void handle(ShapeDataEvent event) {
        if(event instanceof ShapeDataTextChanged e){
            context.setText(((ShapeDataTextChanged) e).getText());
        }
    }
}

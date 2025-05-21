package CanvasApp.ViewModel.EventHandler.CanvasHandler.Strategy;

import CanvasApp.Model.Event.ShapeEvent;
import CanvasApp.Model.Event.ShapeModelTextChanged;
import CanvasApp.Model.ShapeModel;
import CanvasApp.Model.Structure.HasText;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;
import CanvasApp.ViewModel.Data.ShapeData.Decorator.ShapeDataDecorator;
import CanvasApp.ViewModel.EventHandler.CanvasHandler.CanvasHandler;

public class StrategyOnShapeTextChanged extends StrategyHandlingCanvas {
    public StrategyOnShapeTextChanged(CanvasHandler context) {
        super(context);
    }

    @Override
    public void handle(ShapeEvent event) {
        if (event instanceof ShapeModelTextChanged textChangedEvent) {
            ShapeModel modelSource = textChangedEvent.source;
            ShapeData exteriorDecorator = context.canvasData.getShapeData(modelSource.getId());
            HasText dataHasText = findTextInShapeDataRecursively(exteriorDecorator);
            System.out.println("[StrategyOnShapeTextChanged] dataHasText : " + dataHasText.getClass().getSimpleName());

            if (dataHasText != null) {
                dataHasText.setText(textChangedEvent.getNewText());
            }
        }
    }

    private HasText findTextInShapeDataRecursively(ShapeData currentData) {
        if (currentData == null) {
            return null;
        }
        if (currentData instanceof HasText hasText) {
            return hasText;
        }
        if (currentData instanceof ShapeDataDecorator) {
            return findTextInShapeDataRecursively(((ShapeDataDecorator) currentData).getDecorated());
        }
        return null;
    }
}
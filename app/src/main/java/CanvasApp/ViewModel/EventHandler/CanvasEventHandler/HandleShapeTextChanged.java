package CanvasApp.ViewModel.EventHandler.CanvasEventHandler;

import CanvasApp.Model.Event.ShapeEvent;
import CanvasApp.Model.Event.ShapeModelTextChanged;
import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.Data.ShapeData.Decorator.TextInShapeData;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;
import CanvasApp.ViewModel.Data.ShapeData.Decorator.ShapeDataDecorator;

public class HandleShapeTextChanged extends HandleCanvas {
    public HandleShapeTextChanged(CanvasHandler context) {
        super(context);
    }

    @Override
    public void handle(ShapeEvent event) {
        if (event instanceof ShapeModelTextChanged textChangedEvent) {
            ShapeModel modelSource = textChangedEvent.source;
            ShapeData exteriorDecorator = context.canvasData.getShapeData(modelSource.getId());
            TextInShapeData textInShapeData = findTextInShapeDataRecursively(exteriorDecorator);

            if (textInShapeData != null) {
                textInShapeData.setText(textChangedEvent.getNewText());
            }
        }
    }

    private TextInShapeData findTextInShapeDataRecursively(ShapeData currentData) {
        if (currentData == null) {
            return null;
        }
        if (currentData instanceof TextInShapeData) {
            return (TextInShapeData) currentData;
        }
        if (currentData instanceof ShapeDataDecorator) {
            return findTextInShapeDataRecursively(((ShapeDataDecorator) currentData).getDecorated());
        }
        return null;
    }
}
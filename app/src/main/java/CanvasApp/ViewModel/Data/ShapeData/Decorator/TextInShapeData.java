package CanvasApp.ViewModel.Data.ShapeData.Decorator;

import CanvasApp.Model.Decorator.TextInShape;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

public class TextInShapeData extends ShapeDataDecorator {
    private final ShapeData decorated;
    private String text;

    public TextInShapeData(TextInShape model, ShapeData decorated) {
        super(model,decorated);
        this.decorated = decorated;
        this.text = model.getText();
    }

    public String getText() { return text; }
    public void setText(String text) {
        this.text = text;
        notify(new TextInShapeDataChanged(this));
    }
}

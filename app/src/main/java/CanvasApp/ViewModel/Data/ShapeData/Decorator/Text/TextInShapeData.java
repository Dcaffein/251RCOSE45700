package CanvasApp.ViewModel.Data.ShapeData.Decorator.Text;

import CanvasApp.Model.Structure.Decorator.TextInShape;
import CanvasApp.Model.Structure.HasText;
import CanvasApp.ViewModel.Data.ShapeData.Decorator.ShapeDataDecorator;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataTextChanged;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

public class TextInShapeData extends ShapeDataDecorator implements HasText {
    private String text;

    public TextInShapeData(TextInShape model, ShapeData decorated) {
        super(model,decorated);
        this.text = model.getText();
    }

    public String getText() { return text; }
    public void setText(String text) {
        this.text = text;
        notify(new ShapeDataTextChanged(this,text));
    }
}

package CanvasApp.ViewModel.Data.ShapeData;

import CanvasApp.Model.Structure.Composite.Leaf.TextModel;
import CanvasApp.Model.Structure.HasText;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataTextChanged;

public class TextShapeData extends ShapeData implements HasText {
    private String text;

    public TextShapeData(TextModel source) {
        super(source);
        text = source.getText();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        System.out.println("[TextShapeData] setText : " + text);
        notify(new ShapeDataTextChanged(this,text));
    }
}

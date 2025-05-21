package CanvasApp.Model.Structure.Composite.Leaf;

import CanvasApp.Model.Event.ShapeModelTextChanged;
import CanvasApp.Model.Structure.HasText;

public class TextModel extends ShapeModelLeaf implements HasText {
    private String text;

    public TextModel(String id, int x, int y, int w, int h, int z, String text) {
        super(id, x, y, w, h, z);
        this.text = text;
    }

    public void setText(String newText) {
        text = newText;
        notify(new ShapeModelTextChanged(this,text));
    }

    public String getText() {
        return text;
    }
}

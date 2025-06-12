package CanvasApp.Model.Composite.ConcreteLeaf;

import CanvasApp.Model.Composite.ShapeModelLeaf;

public class TextModel extends ShapeModelLeaf  {
    private String text;

    public TextModel(String id, int x, int y, int w, int h, int z, String text) {
        super(id, x, y, w, h, z);
        this.text = text;
    }

    public void setText(String newText) {
        text = newText;
        //notify
    }

    public String getText() {
        return text;
    }
}

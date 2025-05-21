package CanvasApp.Model.Composite.Leaf;

public class TextModel extends ShapeModelLeaf{
    private String text = "text";

    public TextModel(String id, int x, int y, int w, int h, int z) {
        super(id, x, y, w, h, z);
    }

    public void setText(String newText) {
        text = newText;
//        notify
    }

    public String getText() {
        return text;
    }
}

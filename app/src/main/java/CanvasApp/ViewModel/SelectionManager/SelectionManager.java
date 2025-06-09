package CanvasApp.ViewModel.SelectionManager;

import CanvasApp.Model.Composite.ShapeModelGroup;
import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.SelectionManager.Event.ShapeSelected;
import CanvasApp.ViewModel.SelectionManager.Event.ShapeUnselected;
import Observer.*;

import java.util.List;

public class SelectionManager extends Observable implements Observer {
    private static SelectionManager instance;
    private final ShapeModel canvas;

    private ShapeModel selected = new ShapeModelGroup();

    public static synchronized void init(ShapeModel canvas){
        if (instance == null) {
            instance = new SelectionManager(canvas);
        }
    }

    public static SelectionManager getInstance(){
        if (instance == null) {
            throw new IllegalStateException("SelectionManager not initialized");
        }
        return instance;
    }

    private SelectionManager(ShapeModel canvas){
        this.canvas = canvas;
    }

    @Override
    public void onUpdate(Event<?> event) {
        //if shape in selected is deleted. then also remove that one from selected
    }

    public List<ShapeModel> getSelectedShapes() {
        return selected.getChildren();
    }

    public void unselectAll() {
        List<ShapeModel> children = selected.getChildren();
        selected.clear();
        notify(new ShapeUnselected(children));
    }

    public void toggleSelection(String id) {
        ShapeModel target = canvas.getChild(id);
        if (target == null) return;

        if (selected.getChild(id) != null) {
            selected.remove(target);
            notify(new ShapeUnselected(List.of(target)));
        } else {
            selected.add(target);
            notify(new ShapeSelected(target));
        }
    }

    public void setPositionBy(int dx, int dy){
        selected.setPositionBy(dx, dy);
    }
    public void setSizeBy(int dw, int dh) {
        selected.setSizeBy(dw, dh);
    }
    public void setPosition(int newX, int newY) {
        selected.setPosition(newX, newY);
    }
    public void setSize(int newW, int newH) {
        selected.setSize(newW, newH);
    }
    public void realign(int newZ) {
        selected.realign(newZ);
    }
}

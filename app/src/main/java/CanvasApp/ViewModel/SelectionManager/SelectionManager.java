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

    public ShapeModel getSelectedShape(){
        return selected;
    }

    public List<ShapeModel> getSelectedShapeList() {
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
            selected.removeChild(target);
            notify(new ShapeUnselected(List.of(target)));
        } else {
            selected.addChild(target);
            notify(new ShapeSelected(target));
        }
    }
}

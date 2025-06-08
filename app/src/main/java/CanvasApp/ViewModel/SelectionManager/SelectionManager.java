package CanvasApp.ViewModel.SelectionManager;

import CanvasApp.Model.ShapeModel;
import CanvasApp.Model.Composite.ShapeModelGroup;
import CanvasApp.ViewModel.SelectionManager.Event.SelectedPropChanged;
import CanvasApp.ViewModel.SelectionManager.Event.ShapeSelected;
import CanvasApp.ViewModel.SelectionManager.Event.ShapeUnselected;
import Observer.Observable;

import java.util.Collection;

public class SelectionManager extends Observable {
    private final ShapeModel selected = new ShapeModelGroup();

    private static final SelectionManager instance = new SelectionManager();
    public SelectionManager() {}
    public static SelectionManager getInstance(){
        return instance;
    }

    public Collection<ShapeModel> getSelected() {
        return selected.getChildren();
    }

    public void deselectAll(){
        selected.clear();
        notify(new ShapeUnselected(selected));
    }

    public void toggleSelection(ShapeModel shape){
        if (selected.getChild(shape.getId())!=null) {
            selected.remove(shape);
            notify(new ShapeUnselected(selected));
        } else {
            selected.add(shape);
            notify(new ShapeSelected(shape));
        }
    }

    public void setPositionBy(int dx, int dy){
        selected.setPositionBy(dx, dy);
        notify(new SelectedPropChanged(selected));
    }
    public void setSizeBy(int dw, int dh) {
        selected.setSizeBy(dw, dh);
        notify(new SelectedPropChanged(selected));
    }
    public void setPosition(int newX, int newY) {
        selected.setPosition(newX, newY);
        notify(new SelectedPropChanged(selected));
    }
    public void setSize(int newW, int newH) {
        selected.setSize(newW, newH);
        notify(new SelectedPropChanged(selected));
    }
    public void realign(int newZ) {
        selected.realign(newZ);
        notify(new SelectedPropChanged(selected));
    }
}

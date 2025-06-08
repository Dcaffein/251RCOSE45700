package CanvasApp.ViewModel.SelectionManager.Event;

import CanvasApp.Model.ShapeModel;
import Observer.Event;

public class SelectedPropChanged extends Event<ShapeModel> {
    public SelectedPropChanged(ShapeModel source) {
        super(source);
    }
}

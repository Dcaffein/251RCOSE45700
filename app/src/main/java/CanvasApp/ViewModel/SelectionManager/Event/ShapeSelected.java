package CanvasApp.ViewModel.SelectionManager.Event;

import CanvasApp.Model.ShapeModel;
import Observer.Event;

public class ShapeSelected extends Event<ShapeModel> {
    public ShapeSelected(ShapeModel source) {
        super(source);
    }
}

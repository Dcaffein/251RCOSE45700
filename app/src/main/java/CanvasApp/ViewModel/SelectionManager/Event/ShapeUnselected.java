package CanvasApp.ViewModel.SelectionManager.Event;

import CanvasApp.Model.ShapeModel;
import Observer.Event;

public class ShapeUnselected extends Event<ShapeModel> {
    public ShapeUnselected(ShapeModel source) {
        super(source);
    }
}

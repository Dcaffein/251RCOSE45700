package CanvasApp.ViewModel.SelectionManager.Event;

import CanvasApp.Model.ShapeModel;
import Observer.Event;

import java.util.List;

public class ShapeUnselected extends Event<List<ShapeModel>> {
    public ShapeUnselected(List<ShapeModel> source) {
        super(source);
    }
}

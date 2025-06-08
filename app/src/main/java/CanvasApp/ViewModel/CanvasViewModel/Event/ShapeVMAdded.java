package CanvasApp.ViewModel.CanvasViewModel.Event;

import CanvasApp.ViewModel.ShapeViewModel.ShapeViewModel;
import Observer.Event;

public class ShapeVMAdded extends Event<ShapeViewModel> {
    public ShapeVMAdded(ShapeViewModel source) {
        super(source);
    }
}

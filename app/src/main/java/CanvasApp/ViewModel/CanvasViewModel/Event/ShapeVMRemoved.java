package CanvasApp.ViewModel.CanvasViewModel.Event;

import CanvasApp.ViewModel.ShapeViewModel.ShapeViewModel;
import Observer.Event;

public class ShapeVMRemoved extends Event<ShapeViewModel> {
    public ShapeVMRemoved(ShapeViewModel source) {
        super(source);
    }
}

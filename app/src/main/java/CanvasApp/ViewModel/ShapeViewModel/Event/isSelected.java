package CanvasApp.ViewModel.ShapeViewModel.Event;

import Observer.Event;

public class isSelected extends Event<Boolean> {
    public isSelected(Boolean source) {
        super(source);
    }
}

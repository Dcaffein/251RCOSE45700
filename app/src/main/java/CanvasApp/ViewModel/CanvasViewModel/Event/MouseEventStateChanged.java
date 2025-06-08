package CanvasApp.ViewModel.CanvasViewModel.Event;

import CanvasApp.ViewModel.CanvasViewModel.State.MouseEventState;
import Observer.Event;

public class MouseEventStateChanged extends Event<MouseEventState> {
    public MouseEventStateChanged(MouseEventState source) {
        super(source);
    }
}

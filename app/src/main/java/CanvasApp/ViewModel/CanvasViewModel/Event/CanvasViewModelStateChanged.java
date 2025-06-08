package CanvasApp.ViewModel.CanvasViewModel.Event;

import CanvasApp.ViewModel.CanvasViewModel.State.CanvasViewModelState;
import Observer.Event;

public class CanvasViewModelStateChanged extends Event<CanvasViewModelState> {
    public CanvasViewModelStateChanged(CanvasViewModelState source) {
        super(source);
    }
}

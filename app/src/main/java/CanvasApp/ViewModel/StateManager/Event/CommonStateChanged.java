package CanvasApp.ViewModel.StateManager.Event;

import CanvasApp.ViewModel.StateManager.State.CommonState;
import Observer.Event;

public class CommonStateChanged extends Event<CommonState> {
    public CommonStateChanged(CommonState source) {
        super(source);
    }
}

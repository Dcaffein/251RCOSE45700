package CanvasApp.ViewModel.CommonStateManager.Event;

import CanvasApp.ViewModel.CommonStateManager.State.CommonState;
import Observer.Event;

public class CommonStateChanged extends Event<CommonState> {
    public CommonStateChanged(CommonState source) {
        super(source);
    }
}

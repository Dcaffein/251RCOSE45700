package CanvasApp.ViewModel.CommonStateManager;

import CanvasApp.ViewModel.CommonStateManager.Event.CommonStateChanged;
import CanvasApp.ViewModel.CommonStateManager.State.CommonState;
import CanvasApp.ViewModel.CommonStateManager.State.StateForSelect;
import Observer.Observable;

public class CommonStateManager extends Observable {
    private static final CommonStateManager instance = new CommonStateManager();
    public CommonStateManager() {}
    public static CommonStateManager getInstance() {
        return instance;
    }

    public CommonState currentState = new StateForSelect();

    public void setCommonState(CommonState newState) {
        currentState = newState;
        notify(new CommonStateChanged(currentState));
    }
}

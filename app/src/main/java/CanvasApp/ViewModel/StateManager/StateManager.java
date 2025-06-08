package CanvasApp.ViewModel.StateManager;

import CanvasApp.ViewModel.StateManager.Event.CommonStateChanged;
import CanvasApp.ViewModel.StateManager.State.CommonState;
import CanvasApp.ViewModel.StateManager.State.StateForSelect;
import Observer.Observable;

public class StateManager extends Observable {
    private static final StateManager instance = new StateManager();
    public StateManager() {}
    public static StateManager getInstance() {
        return instance;
    }

    public CommonState currentState = new StateForSelect();

    public void setState(CommonState newState) {
        currentState = newState;
        System.out.println("state set to " + newState.getClass().getName());
        notify(new CommonStateChanged(currentState));
    }
}

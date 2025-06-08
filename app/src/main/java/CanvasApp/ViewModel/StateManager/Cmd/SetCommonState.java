package CanvasApp.ViewModel.StateManager.Cmd;

import CanvasApp.ViewModel.StateManager.State.CommonState;
import CanvasApp.ViewModel.StateManager.StateManager;
import Command.Command;

public class SetCommonState implements Command {
    private final StateManager stateManager;
    private final CommonState commonState;

    public SetCommonState(StateManager stateManager, CommonState commonState) {
        this.stateManager = stateManager;
        this.commonState = commonState;
    }

    @Override
    public void execute() {
        stateManager.setState(commonState);
    }
}

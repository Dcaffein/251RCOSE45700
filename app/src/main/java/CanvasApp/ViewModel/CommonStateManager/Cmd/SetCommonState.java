package CanvasApp.ViewModel.CommonStateManager.Cmd;

import CanvasApp.ViewModel.CommonStateManager.State.CommonState;
import CanvasApp.ViewModel.CommonStateManager.CommonStateManager;
import Command.Command;

public class SetCommonState implements Command {
    private final CommonStateManager commonStateManager;
    private final CommonState commonState;

    public SetCommonState(CommonStateManager commonStateManager, CommonState commonState) {
        this.commonStateManager = commonStateManager;
        this.commonState = commonState;
    }

    @Override
    public void execute() {
        commonStateManager.setCommonState(commonState);
    }
}

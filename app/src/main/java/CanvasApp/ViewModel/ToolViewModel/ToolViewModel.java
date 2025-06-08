package CanvasApp.ViewModel.ToolViewModel;

import CanvasApp.ViewModel.StateManager.StateManager;
import Observer.Observable;

public class ToolViewModel extends Observable{
    public StateManager stateManager = StateManager.getInstance();
}

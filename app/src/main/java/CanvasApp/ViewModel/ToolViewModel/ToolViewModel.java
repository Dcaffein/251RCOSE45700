package CanvasApp.ViewModel.ToolViewModel;

import CanvasApp.ViewModel.SelectionManager.SelectionManager;
import CanvasApp.ViewModel.StateManager.StateManager;
import Observer.Observable;

public class ToolViewModel extends Observable{
    public SelectionManager selectionManager = SelectionManager.getInstance();
    public StateManager stateManager = StateManager.getInstance();
}

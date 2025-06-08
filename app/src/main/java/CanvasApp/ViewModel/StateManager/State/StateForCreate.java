package CanvasApp.ViewModel.StateManager.State;

import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.StateManager.StateManager;

public class StateForCreate implements CommonState {
    public ShapeModel shapeForCreation;

    public StateForCreate(ShapeModel shape) {
        this.shapeForCreation = shape;
    }

    @Override
    public void handle(StateManager stateManager) {}
}

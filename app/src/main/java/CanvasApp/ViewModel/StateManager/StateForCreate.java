package CanvasApp.ViewModel.StateManager;

import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.StateManager.State.CommonState;

public class StateForCreate implements CommonState {
    public ShapeModel shapeForCreation;

    public StateForCreate(ShapeModel shape) {
        this.shapeForCreation = shape;
    }

    @Override
    public void handle(StateManager stateManager) {}
}

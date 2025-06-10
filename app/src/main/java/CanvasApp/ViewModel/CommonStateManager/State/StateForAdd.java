package CanvasApp.ViewModel.CommonStateManager.State;

import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.CommonStateManager.CommonStateManager;

public class StateForAdd implements CommonState {
    public ShapeModel shapeForAdd;

    public StateForAdd(ShapeModel shape) {
        this.shapeForAdd = shape;
    }

    @Override
    public void handle(CommonStateManager commonStateManager) {}
}

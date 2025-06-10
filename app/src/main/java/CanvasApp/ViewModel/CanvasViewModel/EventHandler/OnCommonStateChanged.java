package CanvasApp.ViewModel.CanvasViewModel.EventHandler;

import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.CanvasViewModel.CanvasViewModel;
import CanvasApp.ViewModel.CanvasViewModel.State.NotWorking;
import CanvasApp.ViewModel.CanvasViewModel.State.ReadyToDrag;
import CanvasApp.ViewModel.CommonStateManager.State.StateForAdd;
import CanvasApp.ViewModel.CommonStateManager.State.CommonState;
import Observer.Event;

public class OnCommonStateChanged implements CanvasViewModelEventHandler{
    @Override
    public void handle(CanvasViewModel canvasViewModel, Event<?> event) {
        CommonState commonState = ((CommonState)event.source);
        if(commonState instanceof StateForAdd stateForAdd){
            ShapeModel shape = stateForAdd.shapeForAdd;
            canvasViewModel.setWhichCreate(shape);
            canvasViewModel.setMouseEventState(new ReadyToDrag());
        } else {
            canvasViewModel.setWhichCreate(null);
            canvasViewModel.setMouseEventState(new NotWorking());
        }
    }
}

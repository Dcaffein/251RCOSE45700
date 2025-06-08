package CanvasApp.ViewModel.CanvasViewModel.EventHandler;

import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.CanvasViewModel.CanvasViewModel;
import CanvasApp.ViewModel.CanvasViewModel.State.NotWorking;
import CanvasApp.ViewModel.CanvasViewModel.State.ReadyToDrag;
import CanvasApp.ViewModel.StateManager.State.StateForCreate;
import CanvasApp.ViewModel.StateManager.State.CommonState;
import Observer.Event;

public class OnCommonStateChanged implements CanvasViewModelEventHandler{
    @Override
    public void handle(CanvasViewModel canvasViewModel, Event<?> event) {
        CommonState commonState = ((CommonState)event.source);
        if(commonState instanceof StateForCreate stateForCreate){
//            System.out.println("StateForCreate : " + stateForCreate.shapeForCreation.getId());
            ShapeModel shape = stateForCreate.shapeForCreation;
            canvasViewModel.setWhichCreate(shape);
            canvasViewModel.setCurrentState(new ReadyToDrag());
        } else {
            canvasViewModel.setWhichCreate(null);
            canvasViewModel.setCurrentState(new NotWorking());
        }
    }
}

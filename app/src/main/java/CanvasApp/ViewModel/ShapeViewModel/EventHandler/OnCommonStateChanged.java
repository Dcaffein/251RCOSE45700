package CanvasApp.ViewModel.ShapeViewModel.EventHandler;

import CanvasApp.ViewModel.ShapeViewModel.ShapeViewModel;
import CanvasApp.ViewModel.ShapeViewModel.State.NotWorking;
import CanvasApp.ViewModel.ShapeViewModel.State.ReadyToSelect;
import CanvasApp.ViewModel.StateManager.State.StateForSelect;
import CanvasApp.ViewModel.StateManager.State.CommonState;
import Observer.Event;

public class OnCommonStateChanged implements ShapeViewModelEventHandler{
    @Override
    public void handle(ShapeViewModel shapeViewModel, Event<?> event) {
        CommonState commonState = ((CommonState)event.source);
        if(commonState instanceof StateForSelect){
//            System.out.println("Selected state: " + commonState.getClass().getName());
            shapeViewModel.setMouseEventState(new ReadyToSelect());
        } else {
            shapeViewModel.setMouseEventState(new NotWorking());
        }
    }
}

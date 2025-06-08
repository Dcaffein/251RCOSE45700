package CanvasApp.ViewModel.CanvasViewModel;

import CanvasApp.Model.Event.ShapeAdded;
import CanvasApp.Model.Event.ShapeRealigned;
import CanvasApp.Model.Event.ShapeRemoved;
import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.CanvasViewModel.Event.MouseEventStateChanged;
import CanvasApp.ViewModel.CanvasViewModel.EventHandler.*;
import CanvasApp.ViewModel.CanvasViewModel.State.MouseEventState;
import CanvasApp.ViewModel.StateManager.StateManager;
import CanvasApp.ViewModel.StateManager.Event.CommonStateChanged;
import Observer.Observable;
import Observer.Observer;
import Observer.Event;

import java.util.HashMap;
import java.util.Map;

public class CanvasViewModel extends Observable implements Observer {
    public ShapeModel canvas;
    public int maxZ = 0;
    private final Map<Class<? extends Event<?>>, CanvasViewModelEventHandler> eventHandlers = new HashMap<>();
    public ShapeModel whichCreate;
    public StateManager stateManager = StateManager.getInstance();
    public MouseEventState currentState;
    public int dragStartX, dragStartY;

    public CanvasViewModel(ShapeModel canvas) {
        this.canvas = canvas;
        canvas.attach(this);
        stateManager.attach(this);
        registerEventHandler();
    }

    public void registerEventHandler(){
        eventHandlers.put(ShapeAdded.class,new OnShapeAdded());
        eventHandlers.put(ShapeRemoved.class,new OnShapeRemoved());
        eventHandlers.put(ShapeRealigned.class,new OnShapeRealigned());
        eventHandlers.put(CommonStateChanged.class,new OnCommonStateChanged());
    }

    public void updateMaxZ(int newZ){
        System.out.println("newZ = " + newZ);
        if(newZ > maxZ){
            maxZ = newZ;
        }
    }

    public void onUpdate(Event<?> event){
        CanvasViewModelEventHandler currentHandler = eventHandlers.get(event.getClass());
        if(currentHandler != null){
            currentHandler.handle(this,event);
        }
    }

    public void setWhichCreate(ShapeModel model){
        whichCreate = model;
    }

    public void setCurrentState(MouseEventState state){
        currentState = state;
//        System.out.println("[CanvasViewModel] setCurrentState: " + currentState.getClass());
        notify(new MouseEventStateChanged(currentState));
    }

    public void setDragStartPoint(int dragStartX,int dragStartY){
        this.dragStartX = dragStartX;
        this.dragStartY = dragStartY;
    }
}

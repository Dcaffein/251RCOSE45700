package CanvasApp.ViewModel.CanvasViewModel;

import CanvasApp.Model.Cmd.CreateShapeCmd;
import CanvasApp.Model.Event.ShapeAdded;
import CanvasApp.Model.Event.ShapeRealigned;
import CanvasApp.Model.Event.ShapeRemoved;
import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.CanvasViewModel.Event.MouseEventStateChanged;
import CanvasApp.ViewModel.CanvasViewModel.EventHandler.*;
import CanvasApp.ViewModel.CanvasViewModel.State.MouseEventState;
import CanvasApp.ViewModel.CommonStateManager.Cmd.SetCommonState;
import CanvasApp.ViewModel.CommonStateManager.CommonStateManager;
import CanvasApp.ViewModel.CommonStateManager.Event.CommonStateChanged;
import CanvasApp.ViewModel.CommonStateManager.State.CommonState;
import CanvasApp.ViewModel.CommonStateManager.State.StateForSelect;
import Observer.Observable;
import Observer.Observer;
import Observer.Event;

import java.util.HashMap;
import java.util.Map;

public class CanvasViewModel extends Observable implements Observer {
    private final ShapeModel canvas;
    private int maxZ = 0;
    private final Map<Class<? extends Event<?>>, CanvasViewModelEventHandler> eventHandlers = new HashMap<>();
    private ShapeModel whichCreate;
    private final CommonStateManager commonStateManager = CommonStateManager.getInstance();
    private MouseEventState mouseEventState;
    private int dragStartX, dragStartY;

    public CanvasViewModel(ShapeModel canvas) {
        this.canvas = canvas;
        canvas.attach(this);
        commonStateManager.attach(this);
        registerEventHandler();
    }

    public void onUpdate(Event<?> event){
        CanvasViewModelEventHandler currentHandler = eventHandlers.get(event.getClass());
        if(currentHandler != null){
            currentHandler.handle(this,event);
        }
    }

    public void registerEventHandler(){
        eventHandlers.put(ShapeAdded.class,new OnShapeAdded());
        eventHandlers.put(ShapeRemoved.class,new OnShapeRemoved());
        eventHandlers.put(ShapeRealigned.class,new OnShapeRealigned());
        eventHandlers.put(CommonStateChanged.class,new OnCommonStateChanged());
    }

    public int getDragStartX(){
        return dragStartX;
    }

    public int getDragStartY(){
        return dragStartY;
    }

    public ShapeModel getWhichCreate() {
        return whichCreate;
    }

    public void updateMaxZ(int newZ){
        System.out.println("newZ = " + newZ);
        if(newZ > maxZ){
            maxZ = newZ;
        }
    }

    public void setWhichCreate(ShapeModel model){
        whichCreate = model;
    }

    public void setMouseEventState(MouseEventState state){
        mouseEventState = state;
        notify(new MouseEventStateChanged(mouseEventState));
    }

    public void setDragStartPoint(int dragStartX,int dragStartY){
        this.dragStartX = dragStartX;
        this.dragStartY = dragStartY;
    }

    public void addWhichCreate(int x, int y, int w, int h){
        whichCreate.moveTo(x, y);
        whichCreate.resizeAs(w,h);
        whichCreate.realign(maxZ+1);

        new CreateShapeCmd(canvas,whichCreate).execute();
        new SetCommonState(commonStateManager,new StateForSelect()).execute();
    }

    public void pressMouse(int x, int y){
        mouseEventState.onMousePressed(this,x,y);
    }

    public void releaseMouse(int x, int y){
        mouseEventState.onMouseReleased(this,x,y);
    }
}

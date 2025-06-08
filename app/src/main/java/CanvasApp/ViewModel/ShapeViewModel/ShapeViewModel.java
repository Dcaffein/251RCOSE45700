package CanvasApp.ViewModel.ShapeViewModel;

import CanvasApp.Model.Event.ShapeMoved;
import CanvasApp.Model.Event.ShapeResized;
import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.SelectionManager.SelectionManager;
import CanvasApp.ViewModel.ShapeViewModel.Event.isSelected;
import CanvasApp.ViewModel.ShapeViewModel.EventHandler.*;
import CanvasApp.ViewModel.ShapeViewModel.State.ReadyToSelect;
import CanvasApp.ViewModel.ShapeViewModel.State.MouseEventState;
import CanvasApp.ViewModel.StateManager.*;
import CanvasApp.ViewModel.StateManager.Event.CommonStateChanged;
import Observer.*;

import java.util.HashMap;
import java.util.Map;

public class ShapeViewModel extends Observable implements Observer {
    public ShapeModel shape;
    public SelectionManager selectionManager = SelectionManager.getInstance();
    public StateManager stateManager = StateManager.getInstance();
    private final Map<Class<? extends Event<?>>, ShapeViewModelEventHandler> eventHandlers = new HashMap<>();
    public int padding = 2;
    public int dragStartX,dragStartY;
    public MouseEventState mouseEventState = new ReadyToSelect();
    public boolean isSelected = false;

    public ShapeViewModel(ShapeModel shape){
        this.shape = shape;
        shape.attach(this);
        selectionManager.attach(this);
        stateManager.attach(this);
        registerHandlers();
    }

    private void registerHandlers(){
        eventHandlers.put(ShapeMoved.class,new OnShapeMoved());
        eventHandlers.put(ShapeResized.class,new OnShapeResized());
        eventHandlers.put(CommonStateChanged.class,new OnCommonStateChanged());
    }

    @Override
    public void onUpdate(Event<?> event) {
        ShapeViewModelEventHandler currentHandler = eventHandlers.get(event.getClass());
        if(currentHandler != null){
            currentHandler.handle(this,event);
        }
    }

    public void setMouseEventState(MouseEventState state){
        mouseEventState = state;
    }

    public boolean isCorner (int x,int y){
        int cornerSize = 10;
        return (x < shape.getW() - cornerSize || y < shape.getH() - cornerSize);
    }

    public void setDragStartPoint(int x,int y){
        this.dragStartX = x;
        this.dragStartY = y;
    }

    public void setSelected(boolean isSelected){
        this.isSelected = isSelected;
        notify(new isSelected(isSelected));
    }
}

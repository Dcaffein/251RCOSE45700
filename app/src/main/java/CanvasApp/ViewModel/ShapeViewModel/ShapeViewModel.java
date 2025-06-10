package CanvasApp.ViewModel.ShapeViewModel;

import CanvasApp.Model.Cmd.MoveBy;
import CanvasApp.Model.Cmd.ResizeBy;
import CanvasApp.Model.Event.ShapeMoved;
import CanvasApp.Model.Event.ShapeReplaced;
import CanvasApp.Model.Event.ShapeResized;
import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.SelectionManager.Cmd.MultiSelect;
import CanvasApp.ViewModel.SelectionManager.Cmd.Select;
import CanvasApp.ViewModel.SelectionManager.Event.ShapeSelected;
import CanvasApp.ViewModel.SelectionManager.Event.ShapeUnselected;
import CanvasApp.ViewModel.SelectionManager.SelectionManager;
import CanvasApp.ViewModel.ShapeViewModel.EventHandler.*;
import CanvasApp.ViewModel.ShapeViewModel.State.ReadyToSelect;
import CanvasApp.ViewModel.ShapeViewModel.State.MouseEventState;
import CanvasApp.ViewModel.CommonStateManager.*;
import CanvasApp.ViewModel.CommonStateManager.Event.CommonStateChanged;
import Observer.*;

import java.util.HashMap;
import java.util.Map;

public class ShapeViewModel extends Observable implements Observer {
    private ShapeModel shape;
    private final SelectionManager selectionManager = SelectionManager.getInstance();
    private final CommonStateManager commonStateManager = CommonStateManager.getInstance();
    private final Map<Class<? extends Event<?>>, ShapeViewModelEventHandler> eventHandlers = new HashMap<>();
    private int padding = 2;
    private int dragStartX,dragStartY;
    private MouseEventState mouseEventState = new ReadyToSelect();
    private boolean isSelected = false;

    public ShapeViewModel(ShapeModel shape){
        this.shape = shape;
        shape.attach(this);
        selectionManager.attach(this);
        commonStateManager.attach(this);
        registerHandlers();
    }

    private void registerHandlers(){
        eventHandlers.put(ShapeMoved.class,new OnShapeMoved());
        eventHandlers.put(ShapeResized.class,new OnShapeResized());
        eventHandlers.put(CommonStateChanged.class,new OnCommonStateChanged());
        eventHandlers.put(ShapeSelected.class,new OnShapeSelected());
        eventHandlers.put(ShapeUnselected.class,new OnShapeUnselected());
        eventHandlers.put(ShapeReplaced.class,new OnShapeReplaced());
    }

    @Override
    public void onUpdate(Event<?> event) {
        ShapeViewModelEventHandler currentHandler = eventHandlers.get(event.getClass());
        if(currentHandler != null){
            currentHandler.handle(this,event);
        }
    }

    public ShapeModel getShape() {
        return shape;
    }

    public void setShape(ShapeModel shape){
        shape.attach(this);
        this.shape = shape;
    }

    public void setMouseEventState(MouseEventState state){
        mouseEventState = state;
    }

    public boolean getSelected(){
        return isSelected;
    }

    public void setSelected(boolean isSelected){
        this.isSelected = isSelected;
        notify(new ShapeSelected(shape));
    }

    public int getPadding() {
        return padding;
    }

    private ShapeModel getSelectedShape(){
        return selectionManager.getSelectedShape();
    }

    public void dragMouse(int x, int y){
        mouseEventState.onMouseDragged(this, x, y);
    }

    public void pressMouse(int x, int y, boolean ctrlDown){
        mouseEventState.onMousePressed(this, x, y,ctrlDown);
    }

    public void releaseMouse(int x, int y){
        mouseEventState.onMouseReleased(this, x, y);
    }

    public boolean isCorner (int x, int y){
        int cornerSize = 10;
        return (x >= shape.getW() - cornerSize && y >= shape.getH() - cornerSize);
    }

    public int getDragStartX(){
        return dragStartX;
    }

    public int getDragStartY(){
        return dragStartY;
    }

    public void setDragStartPoint(int x,int y){
        this.dragStartX = x;
        this.dragStartY = y;
    }

    public void selectThis(){
        new Select(selectionManager,shape).execute();
    }

    public void multiSelectWithThis(){
        new MultiSelect(selectionManager,shape).execute();
    }

    public void moveBy(int dx, int dy){
        new MoveBy(getSelectedShape(),dx,dy).execute();
    }

    public void resizeBy(int dw, int dh) {
        new ResizeBy(getSelectedShape(),dw,dh).execute();
    }
}

package CanvasApp.ViewModel.PropertyViewModel;

import CanvasApp.Model.Cmd.MoveTo;
import CanvasApp.Model.Cmd.Realign;
import CanvasApp.Model.Cmd.ResizeAs;
import CanvasApp.Model.Event.ShapeMoved;
import CanvasApp.Model.Event.ShapeRealigned;
import CanvasApp.Model.Event.ShapeResized;
import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.PropertyViewModel.Event.PropertyViewModelUpdated;
import CanvasApp.ViewModel.PropertyViewModel.EventHandlers.OnShapeManipulated;
import CanvasApp.ViewModel.PropertyViewModel.EventHandlers.OnShapeSelected;
import CanvasApp.ViewModel.PropertyViewModel.EventHandlers.OnShapeUnselected;
import CanvasApp.ViewModel.PropertyViewModel.EventHandlers.PropertyViewModelEventHandler;
import CanvasApp.ViewModel.SelectionManager.Event.ShapeSelected;
import CanvasApp.ViewModel.SelectionManager.Event.ShapeUnselected;
import CanvasApp.ViewModel.SelectionManager.SelectionManager;
import Observer.Observable;
import Observer.Observer;
import Observer.Event;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PropertyViewModel extends Observable implements Observer {
    private final SelectionManager selectionManager = SelectionManager.getInstance();

    private int x = -1;
    private int y = -1;
    private int w = -1;
    private int h = -1;
    private int z = -1;

    private final Map<Class<? extends Event<?>>, PropertyViewModelEventHandler> eventHandlers = new HashMap<>();

    public PropertyViewModel() {
        selectionManager.attach(this);
        registerEventHandlers();
    }

    @Override
    public void onUpdate(Event<?> event) {
        PropertyViewModelEventHandler currentHandler = eventHandlers.get(event.getClass());
        if(currentHandler != null){
            currentHandler.handle(this,event);
        }
    }

    private void registerEventHandlers(){
        eventHandlers.put(ShapeSelected.class,new OnShapeSelected());
        eventHandlers.put(ShapeUnselected.class,new OnShapeUnselected());
        eventHandlers.put(ShapeMoved.class,new OnShapeManipulated());
        eventHandlers.put(ShapeResized.class,new OnShapeManipulated());
        eventHandlers.put(ShapeRealigned.class,new OnShapeManipulated());
    }

    public void recalculate() {
        List<ShapeModel> shapes = selectionManager.getSelectedShapeList();
        if (shapes.isEmpty()) {
            x = y = w = h = z = -1;
        } else {
            int fx = shapes.getFirst().getX();
            x = shapes.stream().allMatch(s -> s.getX() == fx) ? fx : -1;
            int fy = shapes.getFirst().getY();
            y = shapes.stream().allMatch(s -> s.getY() == fy) ? fy : -1;
            int fw = shapes.getFirst().getW();
            w = shapes.stream().allMatch(s -> s.getW() == fw) ? fw : -1;
            int fh = shapes.getFirst().getH();
            h = shapes.stream().allMatch(s -> s.getH() == fh) ? fh : -1;
            int fz = shapes.getFirst().getZ();
            z = shapes.stream().allMatch(s -> s.getZ() == fz) ? fz : -1;
        }

        notify(new PropertyViewModelUpdated(this));

//        System.out.printf("[PropertyData] recalculate : x=%d, y=%d, w=%d, h=%d, z=%d%n", x, y, w, h, z);
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getW() { return w; }
    public int getH() { return h; }
    public int getZ() { return z; }

    public ShapeModel getSelectedShape() {
        return selectionManager.getSelectedShape();
    }

    public void moveTo(int newX, int newY) {
        new MoveTo(getSelectedShape(), newX, newY).execute();
    }

    public void resizeAs(int newW, int newH) {
        new ResizeAs(getSelectedShape(), newW, newH).execute();
    }

    public void realign(int newZ){
        new Realign(getSelectedShape(), newZ).execute();
    }
}

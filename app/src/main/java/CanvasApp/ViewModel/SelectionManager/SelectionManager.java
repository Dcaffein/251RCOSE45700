package CanvasApp.ViewModel.SelectionManager;

import CanvasApp.Model.Composite.ShapeModelGroup;
import CanvasApp.Model.Event.ShapeReplaced;
import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.SelectionManager.Event.ShapeSelected;
import CanvasApp.ViewModel.SelectionManager.Event.ShapeUnselected;
import CanvasApp.ViewModel.SelectionManager.EventHandler.OnShapeDeleted;
import CanvasApp.ViewModel.SelectionManager.EventHandler.OnShapeReplaced;
import CanvasApp.ViewModel.SelectionManager.EventHandler.SelectionManagerEventHandler;
import Observer.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectionManager extends Observable implements Observer {
    private static SelectionManager instance;
    private final ShapeModel canvas;

    private final ShapeModel selected = new ShapeModelGroup();

    private final Map<Class<? extends Event<?>>, SelectionManagerEventHandler> eventHandlers = new HashMap<>();


    public static synchronized void init(ShapeModel canvas){
        if (instance == null) {
            instance = new SelectionManager(canvas);
        }
    }

    public static SelectionManager getInstance(){
        if (instance == null) {
            throw new IllegalStateException("SelectionManager not initialized");
        }
        return instance;
    }

    private SelectionManager(ShapeModel canvas){
        this.canvas = canvas;
        registerHandlers();
    }

    private void registerHandlers(){
        eventHandlers.put(ShapeSelected.class, new OnShapeDeleted());
        eventHandlers.put(ShapeReplaced.class, new OnShapeReplaced());
    }

    @Override
    public void onUpdate(Event<?> event) {
        SelectionManagerEventHandler currentHandler = eventHandlers.get(event.getClass());
        if(currentHandler != null){
            currentHandler.handle(this,event);
        }
    }

    public ShapeModel getSelectedShape(){
        return selected;
    }

    public List<ShapeModel> getSelectedShapeList() {
        return selected.getChildren();
    }

    public ShapeModel getShape(String id){
        return selected.getChild(id);
    }

    public void unselectAll() {
        List<ShapeModel> children = selected.getChildren();
        for (ShapeModel shape : children) {
            shape.detach(this);
//            System.out.println("[unselectAll] : shape: " + shape);
        }
        selected.clear();
        notify(new ShapeUnselected(children));
    }

    public void toggleSelection(String id) {
        ShapeModel target = canvas.getChild(id);
        if (target == null) return;

        if (selected.getChild(id) != null) {
            selected.removeChild(target);
            target.detach(this);
            notify(new ShapeUnselected(List.of(target)));
        } else {
            selected.addChild(target);
            target.attach(this);
//            System.out.println("[toggleSelection] : target.getObservers(): " + target.getObservers());
            notify(new ShapeSelected(target));

        }
    }

    public void add(ShapeModel shape) {
//        System.out.println("[add] : target: " + shape);
        selected.addChild(shape);
//        System.out.println("[add] : getChildren(): " + selected.getChildren());
        shape.attach(this);
        notify(new ShapeSelected(shape));
    }

    public void remove(String id) {
        ShapeModel target = canvas.getChild(id);
        if (target == null) return;
        target.detach(this);
//        System.out.println("[remove] : target: " + target);
        notify(new ShapeUnselected(List.of(target)));
    }
}

package CanvasApp.Model.Canvas;

import Command.Command;
import Observer.Observable;
import CanvasApp.Model.Shape.Composite.Leaf.ShapeModelLeaf;

import java.util.*;

public class CanvasModel extends Observable {
    private final Map<String, ShapeModelLeaf> shapes = new HashMap<>();

    public void handleCmd(Command cmd) {
        cmd.execute();
    }

    public void addShape(ShapeModelLeaf shape) {
        shapes.put(shape.getId(), shape);
    }

    public void removeShape(String id) {
//        notify(new ShapeRemoved(shapes.get(id)));
        shapes.remove(id);
    }

    public ShapeModelLeaf getShape(String id) {
        return shapes.get(id);
    }

    public Collection<ShapeModelLeaf> getShapes() {
        return shapes.values();
    }
}

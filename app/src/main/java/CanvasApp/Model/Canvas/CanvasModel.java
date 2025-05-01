package CanvasApp.Model.Canvas;

import CanvasApp.Model.Canvas.Observer.CanvasModelShapeRemoved;
import CanvasApp.Model.Shape.Observer.ShapeModelRealigned;
import Command.Command;
import Observer.Observable;
import CanvasApp.Model.Shape.ShapeModel;

import java.util.*;
import java.util.stream.Collectors;

public class CanvasModel extends Observable {
    private final Map<String, ShapeModel> shapes = new HashMap<>();

    public void handleCmd(Command cmd) {
        cmd.execute();
    }

    public void addShape(ShapeModel shape) {
        shapes.put(shape.getId(), shape);
        System.out.println("[CanvasModel] addShape: id=" + shape.getId());
    }

    public void removeShape(String id) {
        shapes.remove(id);
        notify(new CanvasModelShapeRemoved(id));
    }

    public ShapeModel getShape(String id) {
        return shapes.get(id);
    }

    public Collection<ShapeModel> getAllShapes() {
        return Collections.unmodifiableCollection(shapes.values());
    }

    public List<ShapeModel> getShapesSortedByZ() {
        return shapes.values().stream()
                .sorted(Comparator.comparingInt(ShapeModel::getZ))
                .collect(Collectors.toList());
    }

    public int getMaxZ() {
        return shapes.values().stream()
                .mapToInt(ShapeModel::getZ)
                .max()
                .orElse(0);
    }

    public boolean contains(String id) {
        return shapes.containsKey(id);
    }

    public void setZ(String id,int z){
        ShapeModel target = shapes.get(id);
        target.setZ(z);
        notify(new ShapeModelRealigned(id,z));
    }
}

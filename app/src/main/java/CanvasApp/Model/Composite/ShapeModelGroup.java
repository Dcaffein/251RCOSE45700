package CanvasApp.Model.Composite;

import CanvasApp.Model.ShapeModel;
import CanvasApp.Model.Event.ShapeAdded;
import CanvasApp.Model.Event.ShapeRemoved;
import CanvasApp.Model.Event.ShapeMoved;
import CanvasApp.Model.Event.ShapeResized;
import CanvasApp.Model.Event.ShapeRealigned;

import java.util.*;

public class ShapeModelGroup extends ShapeModel {
    private final Map<String, ShapeModel> children = new HashMap<>();
    private final String id = UUID.randomUUID().toString();

    @Override
    public String getId() {
        return id;
    }

    @Override
    public int getX() {
        return children.values().stream()
                .mapToInt(ShapeModel::getX)
                .min()
                .orElse(0);
    }

    @Override
    public int getY() {
        return children.values().stream()
                .mapToInt(ShapeModel::getY)
                .min()
                .orElse(0);
    }

    @Override
    public int getW() {
        if (children.isEmpty()) return 0;
        int minX = getX();
        int maxX = children.values().stream()
                .mapToInt(s -> s.getX() + s.getW())
                .max()
                .orElse(minX);
        return maxX - minX;
    }

    @Override
    public int getH() {
        if (children.isEmpty()) return 0;
        int minY = getY();
        int maxY = children.values().stream()
                .mapToInt(s -> s.getY() + s.getH())
                .max()
                .orElse(minY);
        return maxY - minY;
    }

    @Override
    public int getZ() {
        return children.values().stream()
                .mapToInt(ShapeModel::getZ)
                .min()
                .orElse(0);
    }

    @Override
    public void setPosition(int newX, int newY) {
        children.values().forEach(m -> m.setPosition(newX, newY));
        notify(new ShapeMoved(this));
    }

    @Override
    public void setSize(int newW, int newH) {
        children.values().forEach(m -> m.setSize(newW, newH));
        notify(new ShapeResized(this));
    }

    @Override
    public void setPositionBy(int dx, int dy) {
        children.values().forEach(m -> m.setPositionBy(dx, dy));
        notify(new ShapeMoved(this));
    }

    @Override
    public void setSizeBy(int dw, int dh) {
        children.values().forEach(m -> m.setSizeBy(dw, dh));
        notify(new ShapeResized(this));
    }


    @Override
    public void realign(int z) {
        children.values().forEach(m -> m.realign(z));
        notify(new ShapeRealigned(this));
    }

    @Override
    public void add(ShapeModel shapeModel) {
        children.put(shapeModel.getId(), shapeModel);
        notify(new ShapeAdded(shapeModel));
    }

    @Override
    public void remove(ShapeModel shapeModel) {
        children.remove(shapeModel.getId());
        notify(new ShapeRemoved(shapeModel.getId()));
    }

    public List<ShapeModel> getChildren() {
        return children.values().stream().toList();
    }

    public void clear() {
        children.clear();
    }

    public ShapeModel getChild(String id) {
        return children.get(id);
    }
}

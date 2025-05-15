package CanvasApp.Model.Shape.Composite;

import CanvasApp.Model.Shape.Event.ShapeComposition.ShapeModelAdded;
import CanvasApp.Model.Shape.Event.ShapeComposition.ShapeModelRemoved;
import CanvasApp.Model.Shape.Event.ShapeUpdate.ShapeModelMoved;
import CanvasApp.Model.Shape.Event.ShapeUpdate.ShapeModelRealigned;
import CanvasApp.Model.Shape.Event.ShapeUpdate.ShapeModelResized;
import CanvasApp.Model.Shape.ShapeModel;
import Command.Command;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ShapeModelGroup extends ShapeModel {
    private final Map<String, ShapeModel> members = new HashMap<>();
    private final String id = UUID.randomUUID().toString();

    @Override
    public String getId() {
        return id;
    }

    @Override
    public int getX() {
        return members.values().stream()
                .mapToInt(ShapeModel::getX)
                .min()
                .orElse(0);
    }

    @Override
    public int getY() {
        return members.values().stream()
                .mapToInt(ShapeModel::getY)
                .min()
                .orElse(0);
    }

    @Override
    public int getW() {
        if (members.isEmpty()) return 0;
        int minX = getX();
        int maxX = members.values().stream()
                .mapToInt(s -> s.getX() + s.getW())
                .max()
                .orElse(minX);
        return maxX - minX;
    }

    @Override
    public int getH() {
        if (members.isEmpty()) return 0;
        int minY = getY();
        int maxY = members.values().stream()
                .mapToInt(s -> s.getY() + s.getH())
                .max()
                .orElse(minY);
        return maxY - minY;
    }

    @Override
    public int getZ() {
        return members.values().stream()
                .mapToInt(ShapeModel::getZ)
                .min()
                .orElse(0);
    }

    @Override
    public void move(int dx, int dy) {
        members.values().forEach(m -> m.move(dx, dy));
        notify(new ShapeModelMoved(this));
    }

    @Override
    public void resize(int dw, int dh) {
        members.values().forEach(m -> m.resize(dw, dh));
        notify(new ShapeModelResized(this));
    }

    @Override
    public void realign(int z) {
        members.values().forEach(m -> m.realign(z));
        notify(new ShapeModelRealigned(this));
    }

    @Override
    public void add(ShapeModel shapeModel) {
        members.put(shapeModel.getId(), shapeModel);
        notify(new ShapeModelAdded(shapeModel));
        System.out.println("[ShapeModelGroup] add: id=" + shapeModel.getId());
    }

    @Override
    public void remove(ShapeModel shapeModel) {
        members.remove(shapeModel.getId());
        notify(new ShapeModelRemoved(this));
        System.out.println("[ShapeModelGroup] remove: id=" + shapeModel.getId());
    }


    public Collection<ShapeModel> getChildren() {
        return members.values();
    }

    public void clear() {
        members.clear();
    }

    public void handleCmd(Command cmd) {
        cmd.execute();
    }

    @Override
    public boolean contains(String id) {
        return false;
    }
}

package CanvasApp.ViewModel.Datas.CanvasData;

import CanvasApp.Factory.ShapeFactory;
import CanvasApp.ViewModel.Datas.CanvasData.Event.CanvasDataShapeAdded;
import CanvasApp.ViewModel.Datas.CanvasData.Event.CanvasDataShapeRealigned;
import CanvasApp.ViewModel.Datas.CanvasData.Event.CanvasDataShapeRemoved;
import CanvasApp.ViewModel.Datas.CanvasData.Event.CanvasDataDraggableSet;
import Observer.Observable;
import CanvasApp.ViewModel.Datas.ShapeData.ShapeData;

import java.util.HashMap;
import java.util.Map;

public class CanvasData extends Observable {
    private final Map<String, ShapeData> shapes = new HashMap<>();
    private int maxZ = 0;
    private boolean draggable = false;

    public ShapeData getShapeData(String id) {
        return shapes.get(id);
    }

    public void addShape(ShapeData shapeData, ShapeFactory shapeFactory) {
        updateMaxZ(shapeData.getZ());
        shapes.put(shapeData.getId(), shapeData);
        notify(new CanvasDataShapeAdded(shapeData, shapeFactory));
        System.out.println("[CanvasData] CanvasData add shapeData="
                + shapeData.getId());
    }

    public void removeShape(String id) {
        notify(new CanvasDataShapeRemoved(shapes.get(id)));
        shapes.remove(id);
    }

    public void realign(ShapeData shapeData) {
        notify(new CanvasDataShapeRealigned(shapeData));
    }

    public void updateMaxZ(int z) {
        if (maxZ < z) {
            maxZ = z;
        }
    }

    public int getMaxZ() {
        return maxZ;
    }

    public boolean isDraggable() {
        return draggable;
    }

    public void setCanvasViewState(boolean draggable) {
        this.draggable = draggable;
        notify(new CanvasDataDraggableSet(this));
    }
}

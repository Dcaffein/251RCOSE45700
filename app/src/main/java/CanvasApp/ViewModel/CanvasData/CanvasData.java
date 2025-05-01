package CanvasApp.ViewModel.CanvasData;

import CanvasApp.Model.Factory.ShapeFactory;
import CanvasApp.ViewModel.CanvasData.Observer.CanvasDataShapeAdded;
import CanvasApp.ViewModel.CanvasData.Observer.CanvasDataShapeRealigned;
import CanvasApp.ViewModel.CanvasData.Observer.CanvasDataShapeRemoved;
import CanvasApp.ViewModel.CanvasData.Observer.CanvasDataDraggableSet;
import Observer.Observable;
import CanvasApp.ViewModel.ShapeData.ShapeData;

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
        System.out.println("[CanvasData] addShape: id=" + shapeData.getId() + ", z=" + shapeData.getZ());
        if (maxZ < shapeData.getZ()) {
            maxZ = shapeData.getZ();
        }
        shapes.put(shapeData.getId(), shapeData);
        notify(new CanvasDataShapeAdded(shapeData.getId(), shapeFactory));
        System.out.println("[CanvasData] notified CanvasDataShapeAdded");
    }


    public void removeShape(String id) {
        shapes.remove(id);
        notify(new CanvasDataShapeRemoved(id));
    }

    public void realignShape(String id,int z) {
        if(maxZ < z) {
            maxZ = z;
        }
        notify(new CanvasDataShapeRealigned(id,z));
    }

    public int getMaxZ() {
        return maxZ;
    }

    public void setCanvasViewState(boolean draggable) {
        System.out.println("[CanvasData] setCanvasViewState = " + draggable);
        this.draggable = draggable;
        notify(new CanvasDataDraggableSet(draggable));
    }

}

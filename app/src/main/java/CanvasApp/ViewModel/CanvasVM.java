package CanvasApp.ViewModel;

import CanvasApp.Factory.RectFactory;
import CanvasApp.Factory.ShapeFactory;
import CanvasApp.Model.Shape.Cmd.CreateShapeLeafCmd;
import CanvasApp.Model.Shape.Composite.ShapeModelGroup;
import CanvasApp.Model.Shape.Event.ShapeComposition.ShapeModelAdded;
import CanvasApp.Model.Shape.ShapeModel;
import CanvasApp.ViewModel.Datas.CanvasData.CanvasData;
import CanvasApp.ViewModel.EventHandler.CanvasEventHandler;
import CanvasApp.ViewModel.Datas.PropertyData.PropertyData;
import CanvasApp.ViewModel.EventHandler.SelectedHandler;
import Command.Command;

public class CanvasVM {
    private final ShapeModel canvas = new ShapeModelGroup();
    public final ShapeModel selected = new ShapeModelGroup();

    private final CanvasData canvasData;
    private ShapeFactory factoryForNewShape;
    private final PropertyData propertyData = new PropertyData(selected);

    CanvasEventHandler canvasEventHandler;
    SelectedHandler selectedHandler;

    public CanvasVM(CanvasData canvasData) {
        this.canvasData = canvasData;
        this.canvasEventHandler = new CanvasEventHandler(canvasData);
        canvas.attach(canvasEventHandler);
        this.selectedHandler = new SelectedHandler(selected, propertyData);
        selected.attach(selectedHandler);
    }

    public ShapeModel getShape(String id) {
        return canvas.getChildren().stream()
                .filter(shape -> shape.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void deSelectAll() {
        selected.clear();
    }

    public void toggleSelect(ShapeModel shapeModel) {
        if (selected.contains(shapeModel.getId())) {
            selected.remove(shapeModel);
        } else {
            selected.add(shapeModel);
            selected.notify(new ShapeModelAdded(shapeModel));
        }
    }

    public void handleCmd(Command command) {
        command.execute();
    }

    public void setCurrentFactory(ShapeFactory selectedShapeFactory) {
        this.factoryForNewShape = selectedShapeFactory;
    }

    public void setCanvasDraggable(boolean draggable) {
        canvasData.setCanvasViewState(draggable);
    }

    public void createShapeLeafByDrag(int x, int y, int w, int h, int z) {
        new CreateShapeLeafCmd(canvas,factoryForNewShape,x,y,w,h,z).execute();
    }

    public PropertyData getPropertyData() {
        return propertyData;
    }
}

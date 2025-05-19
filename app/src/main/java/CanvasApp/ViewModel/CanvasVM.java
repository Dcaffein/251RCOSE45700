package CanvasApp.ViewModel;

import CanvasApp.Factory.ShapeFactory;
import CanvasApp.Model.Cmd.CreateShapeCmd;
import CanvasApp.Model.Cmd.DecorateCmd;
import CanvasApp.Model.Composite.ShapeModelGroup;
import CanvasApp.Model.Decorator.ShapeDecorator;
import CanvasApp.Model.Decorator.TextInShape;
import CanvasApp.Model.Event.ShapeModelAdded;
import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.Command.ShapeCmd.DecorateWithTextCmd;
import CanvasApp.ViewModel.Data.CanvasData.CanvasData;
import CanvasApp.ViewModel.EventHandler.CanvasEventHandler.CanvasHandler;
import CanvasApp.ViewModel.Data.PropertyData.PropertyData;
import CanvasApp.ViewModel.EventHandler.SelectedHandler.SelectedHandler;
import Command.Command;

public class CanvasVM {
    private final ShapeModel canvas = new ShapeModelGroup();
    public final ShapeModel selected = new ShapeModelGroup();

    private final CanvasData canvasData;

    private ShapeFactory factoryForNewShape;
    private final PropertyData propertyData = new PropertyData(selected);

    CanvasHandler canvasHandler;
    SelectedHandler selectedHandler;

    public CanvasVM(CanvasData canvasData) {
        this.canvasData = canvasData;
        this.canvasHandler = new CanvasHandler(canvasData);
        canvas.attach(canvasHandler);
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
        new CreateShapeCmd(canvas,factoryForNewShape,x,y,w,h,z).execute();
    }

    public PropertyData getPropertyData() {
        return propertyData;
    }

    public void decorateShapeWithText(ShapeModel originalShape,TextInShape textDecorator){
        DecorateCmd cmd = new DecorateCmd(originalShape,textDecorator,canvas);
        cmd.execute();
    }

    public void updateShapeTextById(ShapeModel shapeModel, String newText) {
        if (shapeModel instanceof ShapeDecorator shapeDecorator) {
            if(shapeDecorator instanceof TextInShape textInShape){
                textInShape.setText(newText);
            } else {
                updateShapeTextById(shapeDecorator.getDecorated(),newText);
            }
        }
    }
}

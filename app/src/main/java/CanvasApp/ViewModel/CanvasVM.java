package CanvasApp.ViewModel;

import CanvasApp.Factory.DecoratorShadowFactory;
import CanvasApp.Factory.DecoratorTextFactory;
import CanvasApp.Factory.ShapeFactory;
import CanvasApp.Model.Cmd.*;
import CanvasApp.Model.Structure.Composite.ShapeModelGroup;
import CanvasApp.Model.Structure.Decorator.Shadow;
import CanvasApp.Model.Structure.Decorator.TextInShape;
import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.Data.CanvasData.CanvasData;
import CanvasApp.ViewModel.EventHandler.CanvasHandler.CanvasHandler;
import CanvasApp.ViewModel.Data.PropertyData.PropertyData;
import CanvasApp.ViewModel.EventHandler.SelectedHandler.SelectedHandler;
import Command.Command;

import java.awt.*;
import java.util.Collection;

public class CanvasVM {
    private final ShapeModel canvas = new ShapeModelGroup();
    private final ShapeModel selected = new ShapeModelGroup();

    private final CanvasData canvasData;

    private ShapeFactory factoryForNewShape;
    private final PropertyData propertyData = new PropertyData(selected);

    CanvasHandler canvasHandler;
    SelectedHandler selectedHandler;

    public CanvasVM(CanvasData canvasData) {
        this.canvasData = canvasData;
        this.canvasHandler = new CanvasHandler(canvasData);
        canvas.attach(canvasHandler);
        this.selectedHandler = new SelectedHandler(propertyData, canvasData);
        selected.attach(selectedHandler);
    }

    public void deSelectAll() {
        selected.clear();
    }

    public void toggleSelect(String id) {
        ShapeModel shapeModel = canvas.getChild(id);
        if(shapeModel == null) return;
        if (selected.getChild(id)!=null) {
            selected.remove(shapeModel);
        } else {
            selected.add(shapeModel);
        }
    }

    public void handleCmd(Command command) {
        command.execute();
    }

    public void moveTo(int newX, int newY){
        new SetPosition(selected,newX,newY).execute();
    }

    public void resizeAs(int newW, int newH){
        new SetSize(selected,newW,newH).execute();
    }

    public void moveByDrag(int dx, int dy) {
        new SetPositionBy(selected,dx,dy).execute();
    }

    public void resizeByDrag(int dw, int dh) {
        new SetSizeBy(selected,dw,dh).execute();
    }

    public void realign(int z){
        selected.realign(z);
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

    public void decoratesWithText(String text) {
        Collection<ShapeModel> selectedShapes = selected.getChildren();
        if (selectedShapes == null || selectedShapes.isEmpty()) {
            return;
        }

        DecoratorTextFactory textFactory = DecoratorTextFactory.getInstance();
        for (ShapeModel originalShape : selectedShapes) {
            System.out.println("[decoratesWithText] decorator : " + originalShape.getClass());
            TextInShape textDecorator = textFactory.createShapeDecorator(originalShape, text);
            new DecorateCmd(originalShape,textDecorator,canvas).execute();
        }
        deSelectAll();
    }

    public void decoratesWithShadow(Color color,int border){
        Collection<ShapeModel> selectedShapes = selected.getChildren();
        if (selectedShapes == null || selectedShapes.isEmpty()) {
            return;
        }

        DecoratorShadowFactory shadowFactory = DecoratorShadowFactory.getInstance();
        for (ShapeModel originalShape : selectedShapes) {
            Shadow shadow = shadowFactory.createShapeDecorator(originalShape, color,border);
            System.out.println("[decoratesWithShadow] decorator : " + originalShape.getClass());
            new DecorateCmd(originalShape,shadow,canvas).execute();
        }
        deSelectAll();
    }

    public void changeText(String id, String text) {
        ShapeModel shapeModel = canvas.getChild(id);
        if(shapeModel == null) return;
        System.out.println("[CanvasVM] text : " + text);
        new ChangeTextCmd(shapeModel, text).execute();
    }
}

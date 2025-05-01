package CanvasApp.ViewModel;

import CanvasApp.Model.Canvas.CanvasModel;
import CanvasApp.Model.Canvas.Cmd.CreateShapeModelCmd;
import CanvasApp.Model.Canvas.Observer.*;
import CanvasApp.Model.Factory.ShapeFactory;
import CanvasApp.Model.Shape.Observer.ShapeModelMoved;
import CanvasApp.Model.Shape.Observer.ShapeModelResized;
import CanvasApp.Model.Shape.Observer.ShapeModelObserver;
import CanvasApp.Model.Shape.Observer.ShapeModelRealigned;
import CanvasApp.Model.Shape.ShapeModel;
import CanvasApp.ViewModel.CanvasData.CanvasData;
import CanvasApp.ViewModel.ShapeData.ShapeData;
import Command.Command;

import java.util.ArrayList;
import java.util.List;

public class CanvasVM implements ShapeModelObserver, CanvasModelObserver {
    //models
    private final CanvasModel canvas = new CanvasModel();

    //canvasData,shapeData
    public final CanvasData canvasData;

    //viewModel tool data
    public CreateShapeModelCmd tempCreateCmd;

    private final List<String> selected = new ArrayList<>();

    public CanvasVM(CanvasData canvasData) {
        this.canvasData = canvasData;
        canvas.attach(this);
    }

    @Override
    public void onShapeAdded(CanvasModelShapeAdded event) {
        System.out.println("[CanvasVM] onShapeAdded: id=" + event.id);

        ShapeModel shapeModel = canvas.getShape(event.id);
        shapeModel.attach(this);

        ShapeFactory shapeFactory = event.getShapeFactory();
        ShapeData shapeData = shapeFactory.createShapeData(shapeModel);

        System.out.println("[CanvasVM] shapeData created: id=" + shapeData.getId());

        canvasData.addShape(shapeData, shapeFactory);
    }


    @Override
    public void onShapeRemoved(CanvasModelShapeRemoved event) {
        canvasData.removeShape(event.id);
    }


    @Override
    public void onShapeZChanged(ShapeModelRealigned event) {
        canvasData.getShapeData(event.id).setZ(event.z);
        canvasData.realignShape(event.id,event.z);
    }

    @Override
    public void onMoved(ShapeModelMoved event) {
        canvasData.getShapeData(event.id).moved(event.x,event.y);
    }

    @Override
    public void onResized(ShapeModelResized event) {
        canvasData.getShapeData(event.id).resized(event.w,event.h);
    }

    @Override
    public void onRealigned(ShapeModelRealigned event) {
        canvasData.getShapeData(event.id).setZ(event.z);
        canvasData.realignShape(event.id,event.z);
    }


    public ShapeModel getShape(String id) {
        return canvas.getShape(id);
    }

    private void deSelectAll(){
        selected.clear();
    }

    private void handleSelected(String id) {
        if (selected.contains(id)) {
            selected.remove(id);
        } else {
            selected.add(id);
        }
        System.out.println("[Selected Shapes] " + selected);
    }

    public void multiSelect(String id){
        handleSelected(id);
    }
    public void select(String id){
        deSelectAll();
        handleSelected(id);
    }

    public void handleCmd(Command command) {
        command.execute();
    }

    public void move(int dx, int dy){
        for(String id : selected){
            getShape(id).move(dx, dy);
        }
    }

    public void realign(int z){
        for(String id : selected){
            canvas.setZ(id,z);
        }
    }

    public void resize(int dw, int dh){
        for(String id : selected){
            getShape(id).resize(dw,dh);
        }
    }

    public void setTempCreateCmd(CreateShapeModelCmd tempCreateCmd) {
        System.out.println("[CanvasVM] setTempCreateCmd called");
        this.tempCreateCmd = tempCreateCmd;
    }

    public void setCanvasDraggable(boolean draggable){
        System.out.println("[CanvasVM] setCanvasDraggable = " + draggable);
        canvasData.setCanvasViewState(draggable);
    }

    public void completeTempCreateCmd(int x, int y, int w, int h, int z){
        tempCreateCmd.Complete(canvas,x,y,w,h,z);
        canvas.handleCmd(tempCreateCmd);
    }
}

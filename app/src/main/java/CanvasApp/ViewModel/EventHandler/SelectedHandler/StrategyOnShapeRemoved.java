package CanvasApp.ViewModel.EventHandler.SelectedHandler;

import CanvasApp.Model.Event.ShapeEvent;
import CanvasApp.Model.Event.ShapeModelAdded;
import CanvasApp.Model.Event.ShapeModelRemoved;
import CanvasApp.Model.ShapeModel;

public class StrategyOnShapeRemoved extends StrategyHandlingSelected {
    public StrategyOnShapeRemoved(SelectedHandler context) {
        super(context);
    }

    @Override
    public void handle(ShapeEvent event) {
        if(event instanceof ShapeModelRemoved e){
            ShapeModel shapeModel = e.source;
            String id = shapeModel.getId();
            context.canvasData.getShapeData(id).setSelected(false);
        }
    }
}

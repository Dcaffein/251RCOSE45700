package CanvasApp.ViewModel.EventHandler.SelectedHandler;

import CanvasApp.Model.Event.ShapeEvent;
import CanvasApp.Model.Event.ShapeModelAdded;
import CanvasApp.Model.ShapeModel;

public class StrategyOnShapeAdded extends StrategyHandlingSelected {
    public StrategyOnShapeAdded(SelectedHandler context) {
        super(context);
    }

    @Override
    public void handle(ShapeEvent event) {
        if(event instanceof ShapeModelAdded e){
            ShapeModel shapeModel = e.source;
            String id = shapeModel.getId();
            context.canvasData.getShapeData(id).setSelected(true);
        }
    }
}

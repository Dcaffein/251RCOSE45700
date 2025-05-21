package CanvasApp.View.ShapeView.EventHandler.Strategy;

import CanvasApp.Model.Structure.HasText;
import CanvasApp.View.ShapeView.EventHandler.ShapeDataEventHandler;
import CanvasApp.View.ShapeView.EventHandler.StrategyHandlingShapeView;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataEvent;
import CanvasApp.ViewModel.Data.ShapeData.Event.ShapeDataTextChanged;

public class StrategyOnShapeDataTextChanged extends StrategyHandlingShapeView {
    public StrategyOnShapeDataTextChanged(ShapeDataEventHandler shapeDataEventHandler) {
        super(shapeDataEventHandler);
    }

    @Override
    public void handle(ShapeDataEvent event) {
        if(event instanceof ShapeDataTextChanged e){
            if(shapeDataEventHandler.shapeViewContext instanceof HasText viewHasText){
                System.out.println("[StrategyOnShapeDataTextChanged] e.getText() : " + e.getText());
                viewHasText.setText(e.getText());
            }
        }
    }
}

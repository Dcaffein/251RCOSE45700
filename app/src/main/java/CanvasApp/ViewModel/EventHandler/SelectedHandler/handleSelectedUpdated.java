package CanvasApp.ViewModel.EventHandler.SelectedHandler;

import CanvasApp.Model.Event.ShapeEvent;

public class handleSelectedUpdated extends HandleSelected{
    public handleSelectedUpdated(SelectedHandler context) {
        super(context);
    }

    @Override
    public void handle(ShapeEvent event) {
        context.propertyData.recalculate();
    }
}

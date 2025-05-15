package CanvasApp.ViewModel.EventHandler;

import CanvasApp.Model.Shape.Event.ShapeComposition.ShapeCompositionObserver;
import CanvasApp.Model.Shape.Event.ShapeComposition.ShapeModelAdded;
import CanvasApp.Model.Shape.Event.ShapeComposition.ShapeModelRemoved;
import CanvasApp.Model.Shape.Event.ShapeUpdate.ShapeModelMoved;
import CanvasApp.Model.Shape.Event.ShapeUpdate.ShapeModelRealigned;
import CanvasApp.Model.Shape.Event.ShapeUpdate.ShapeModelResized;
import CanvasApp.Model.Shape.Event.ShapeUpdate.ShapeUpdateObserver;
import CanvasApp.Model.Shape.ShapeModel;
import CanvasApp.ViewModel.Datas.PropertyData.PropertyData;

public class SelectedHandler implements ShapeUpdateObserver, ShapeCompositionObserver {
    PropertyData propertyData;

    public SelectedHandler(ShapeModel selected, PropertyData propertyData) {
        selected.attach(this);
        this.propertyData = propertyData;
    }

    @Override
    public void onShapeAdded(ShapeModelAdded event) {
        propertyData.recalculate();
        System.out.printf("onShapeAdded : id:%s ", event.source.getId());
    }

    @Override
    public void onShapeRemoved(ShapeModelRemoved event) {
        propertyData.recalculate();
        System.out.printf("onShapeRemoved : id:%s ", event.source.getId());
    }

    @Override
    public void onShapeMoved(ShapeModelMoved event) {
        propertyData.recalculate();
    }

    @Override
    public void onShapeResized(ShapeModelResized event) {
        propertyData.recalculate();
    }

    @Override
    public void onShapeRealigned(ShapeModelRealigned event) {
        propertyData.recalculate();
    }
}

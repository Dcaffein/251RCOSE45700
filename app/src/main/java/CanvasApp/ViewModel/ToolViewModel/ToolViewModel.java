package CanvasApp.ViewModel.ToolViewModel;

import CanvasApp.Model.Cmd.CreateShapeCmd;
import CanvasApp.Model.Cmd.Replace;
import CanvasApp.Model.Decorator.ShapeDecorator;
import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.CommonStateManager.Cmd.SetCommonState;
import CanvasApp.ViewModel.CommonStateManager.State.CommonState;
import CanvasApp.ViewModel.CommonStateManager.State.StateForAdd;
import CanvasApp.ViewModel.CommonStateManager.State.StateForSelect;
import CanvasApp.ViewModel.SelectionManager.Cmd.UnselectAll;
import CanvasApp.ViewModel.SelectionManager.SelectionManager;
import CanvasApp.ViewModel.CommonStateManager.CommonStateManager;
import Observer.Observable;

import java.util.List;

public class ToolViewModel extends Observable{
    private final ShapeModel canvas;
    private final SelectionManager selectionManager = SelectionManager.getInstance();
    private final CommonStateManager commonStateManager = CommonStateManager.getInstance();

    public ToolViewModel(ShapeModel canvas) {
        this.canvas = canvas;
    }

    public List<ShapeModel> getSelectedShapes() {
        return selectionManager.getSelectedShapeList();
    }

    public void readyToSelect() {
        new SetCommonState(commonStateManager,new StateForSelect()).execute();
    }

    public void readyToAdd(ShapeModel shape) {
        new UnselectAll(selectionManager).execute();
        new SetCommonState(commonStateManager,new StateForAdd(shape)).execute();
    }

    public void decorate(ShapeDecorator decorator) {
        new Replace(canvas,decorator.getDecorated(),decorator).execute();
    }
}

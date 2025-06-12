package CanvasApp.ViewModel.ToolViewModel;

import CanvasApp.Model.Cmd.Replace;
import CanvasApp.Model.Decorator.Cmd.UnDecorate;
import CanvasApp.Model.Decorator.ShapeDecorator;
import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.CommonStateManager.Cmd.SetCommonState;
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

    public boolean undoExistingDeco(ShapeModel targetShape, Class<? extends ShapeDecorator> decoType) {
        //이미 target에 newDecorator가 적용되어 있으면 unDeco
        if (targetShape instanceof ShapeDecorator alreadyDecorated) {

            ShapeDecorator targetDecorator = alreadyDecorated.getDecorator(decoType);
            // targetDecorator 가장 바깥쪽 Decorator 라면
            if(targetDecorator == targetShape){
                new Replace(canvas,targetDecorator,targetDecorator.getDecorated()).execute();
                return true;
            // targetDecorator 가장 바깥쪽 Decorator 가 아니라면
            } else if(targetDecorator != null) {
                new UnDecorate(alreadyDecorated,decoType).execute();
                return true;
            }
        }
        //targetDeco == null, decorator 중에서 적용하려는 deco 없었음 || deco 하나도 아예 적용안됨
        return false;
    }

    public void applyDeco(ShapeDecorator decorator) {
        new Replace(canvas,decorator.getDecorated(),decorator).execute();
    }
}

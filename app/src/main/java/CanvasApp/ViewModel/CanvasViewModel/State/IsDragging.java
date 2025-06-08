package CanvasApp.ViewModel.CanvasViewModel.State;

import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.CanvasViewModel.CanvasViewModel;
import CanvasApp.ViewModel.StateManager.StateForSelect;

import java.awt.*;

import static utils.MathUtil.computeRectangle;

public class IsDragging implements CanvasViewModelState{
    @Override
    public void onMousePressed(CanvasViewModel canvasViewModel, int x, int y) {

    }

    @Override
    public void onMouseReleased(CanvasViewModel canvasViewModel, int x, int y) {
        Rectangle rect = computeRectangle(canvasViewModel.dragStartX, canvasViewModel.dragStartY, x, y);
        ShapeModel modelForCreation = canvasViewModel.whichCreate;

        if(modelForCreation == null) return;
        modelForCreation.setPosition(rect.x, rect.y);
        modelForCreation.setSize(rect.width, rect.height);
        modelForCreation.realign(canvasViewModel.maxZ+1);
        canvasViewModel.canvas.add(modelForCreation);

        canvasViewModel.stateManager.setState(new StateForSelect());
    }
}

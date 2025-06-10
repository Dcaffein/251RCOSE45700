package CanvasApp.ViewModel.CanvasViewModel.State;

import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.CanvasViewModel.CanvasViewModel;

import java.awt.*;

import static utils.MathUtil.computeRectangle;

public class IsDragging implements MouseEventState {
    @Override
    public void onMousePressed(CanvasViewModel canvasViewModel, int x, int y) {

    }

    @Override
    public void onMouseReleased(CanvasViewModel canvasViewModel, int x, int y) {
        Rectangle rect = computeRectangle(canvasViewModel.getDragStartX(), canvasViewModel.getDragStartY(), x, y);
        ShapeModel modelForAdd = canvasViewModel.getWhichCreate();
        if(modelForAdd == null) return;
        canvasViewModel.addWhichCreate(rect.x, rect.y, rect.width, rect.height);
    }
}

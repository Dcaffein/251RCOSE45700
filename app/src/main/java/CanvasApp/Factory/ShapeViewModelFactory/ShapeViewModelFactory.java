package CanvasApp.Factory.ShapeViewModelFactory;

import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.ShapeViewModel.ShapeViewModel;

public class ShapeViewModelFactory {
    private static final ShapeViewModelFactory instance = new ShapeViewModelFactory();
    public ShapeViewModelFactory(){};
    public static ShapeViewModelFactory getInstance(){
        return instance;
    }

    public ShapeViewModel createShapeViewModel(ShapeModel shapeModel){
        return new ShapeViewModel(shapeModel);
    }
}

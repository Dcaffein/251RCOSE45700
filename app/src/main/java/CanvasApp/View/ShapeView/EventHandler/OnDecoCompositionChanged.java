package CanvasApp.View.ShapeView.EventHandler;

import CanvasApp.Factory.DrawerRegistry;
import CanvasApp.Model.Decorator.ShapeDecorator;
import CanvasApp.Model.ShapeModel;
import CanvasApp.View.ShapeView.Drawer.Drawer;
import CanvasApp.View.ShapeView.ShapeView;
import CanvasApp.ViewModel.ShapeViewModel.Event.DecoCompositionChanged;
import Observer.Event;

public class OnDecoCompositionChanged implements ShapeViewEventHandler{
    @Override
    public void handle(ShapeView shapeView, Event<?> event) {
        if (event instanceof DecoCompositionChanged) {
            shapeView.drawer = createNewChainedDrawer(shapeView.viewModel.getShape());
            shapeView.repaint();
        }
    }

    private Drawer createNewChainedDrawer(ShapeModel model){
        Drawer drawer = DrawerRegistry.factoryFor(model).createDrawer();
        if(model instanceof ShapeDecorator decorator){
            drawer.decorated = createNewChainedDrawer(decorator.getDecorated());
        }
        return drawer;
    }
}

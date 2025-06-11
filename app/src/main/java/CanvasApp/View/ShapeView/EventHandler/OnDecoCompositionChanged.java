package CanvasApp.View.ShapeView.EventHandler;

import CanvasApp.Factory.ShapeFactoryRegistry;
import CanvasApp.Model.Decorator.ShapeDecorator;
import CanvasApp.Model.ShapeModel;
import CanvasApp.View.ShapeView.Drawer.Drawer;
import CanvasApp.View.ShapeView.ShapeView;
import Observer.Event;

public class OnDecoCompositionChanged implements ShapeViewEventHandler{
    @Override
    public void handle(ShapeView shapeView, Event<?> event) {
        if (event.source instanceof ShapeDecorator decorator) {
            shapeView.drawer = createNewChainedDrawer(decorator);
            shapeView.repaint();
        }
    }

    private Drawer createNewChainedDrawer(ShapeModel model){
        Drawer drawer = ShapeFactoryRegistry.factoryFor(model).createDrawer(model);
        if(model instanceof ShapeDecorator decorator){
            drawer.decorated = createNewChainedDrawer(decorator.getDecorated());
        }
        return drawer;
    }
}

package CanvasApp.View.ShapeView.EventHandler;

import CanvasApp.Factory.ShapeFactoryRegistry;
import CanvasApp.Model.Decorator.ShapeDecorator;
import CanvasApp.View.ShapeView.Drawer.Drawer;
import CanvasApp.View.ShapeView.ShapeView;
import Observer.Event;

public class OnShapeReplaced implements ShapeViewEventHandler{
    @Override
    public void handle(ShapeView shapeView, Event<?> event) {
        if (event.source instanceof ShapeDecorator decorator) {
            Drawer drawer = ShapeFactoryRegistry.factoryFor(decorator).createDrawer(decorator);
            drawer.decorated = shapeView.drawer;
            shapeView.drawer = drawer;
            shapeView.repaint();
        }
    }
}

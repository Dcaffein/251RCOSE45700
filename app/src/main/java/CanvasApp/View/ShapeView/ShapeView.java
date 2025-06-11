package CanvasApp.View.ShapeView;

import CanvasApp.Model.Event.ShapeMoved;
import CanvasApp.Model.Event.ShapeReplaced;
import CanvasApp.Model.Event.ShapeResized;
import CanvasApp.View.ShapeView.EventHandler.*;
import CanvasApp.ViewModel.SelectionManager.Event.ShapeSelected;
import CanvasApp.ViewModel.SelectionManager.Event.ShapeUnselected;
import CanvasApp.ViewModel.ShapeViewModel.Event.DecoCompositionChanged;
import Observer.Observer;
import Observer.Event;
import CanvasApp.Model.ShapeModel;
import CanvasApp.View.ShapeView.Drawer.Drawer;
import CanvasApp.ViewModel.ShapeViewModel.Cmd.DragMouse;
import CanvasApp.ViewModel.ShapeViewModel.Cmd.PressMouse;
import CanvasApp.ViewModel.ShapeViewModel.Cmd.ReleaseMouse;
import CanvasApp.ViewModel.ShapeViewModel.ShapeViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class ShapeView extends JComponent implements Observer{
    public final ShapeViewModel viewModel;
    public Drawer drawer;
    private final Map<Class<? extends Event<?>>, ShapeViewEventHandler> eventHandlers = new HashMap<>();

    public ShapeView(ShapeViewModel viewModel, Drawer drawer) {
        this.viewModel = viewModel;
        this.viewModel.attach(this);
        this.drawer = drawer;
        setLayout(null);

        ShapeModel shape = viewModel.getShape();
        setBounds(shape.getX(), shape.getY(), shape.getW(), shape.getH());
        addMouseEventListener();
        setName(viewModel.getShape().getId());
        registerEventHandler();
    }

    private void registerEventHandler(){
        eventHandlers.put(ShapeMoved.class, new OnShapeMoved());
        eventHandlers.put(ShapeResized.class, new OnShapeResized());
        eventHandlers.put(ShapeSelected.class, new OnShapeSelection());
        eventHandlers.put(ShapeUnselected.class, new OnShapeSelection());
        eventHandlers.put(DecoCompositionChanged.class,new OnDecoCompositionChanged());
    }

    private void addMouseEventListener(){
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                (new PressMouse(viewModel,e)).execute();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                (new ReleaseMouse(viewModel,e)).execute();
            }
        });

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                (new DragMouse(viewModel,e)).execute();
            }
        });
    }


    @Override
    public void onUpdate(Event<?> event) {
        ShapeViewEventHandler currentHandler = eventHandlers.get(event.getClass());
        if(currentHandler != null){
            currentHandler.handle(this,event);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        draw(g);
    }

    public void draw(Graphics g){
        drawer.draw(g,this);

        if (viewModel.getSelected()) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(Color.BLUE);
            g2.setStroke(new BasicStroke(2));
            g2.drawRect(1, 1, getWidth() - 2, getHeight() - 2);
            g2.dispose();
        }
    }
}

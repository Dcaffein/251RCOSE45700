package CanvasApp.View.CanvasView;

import CanvasApp.View.CanvasView.EventHandler.CanvasViewEventHandler;
import CanvasApp.View.CanvasView.EventHandler.OnMouseEventStateChanged;
import CanvasApp.View.CanvasView.EventHandler.OnShapeAdded;
import CanvasApp.View.CanvasView.EventHandler.OnShapeRealigned;
import CanvasApp.ViewModel.CanvasViewModel.Cmd.PressBackground;
import CanvasApp.ViewModel.CanvasViewModel.Cmd.PressMouse;
import CanvasApp.ViewModel.CanvasViewModel.Cmd.ReleaseMouse;
import CanvasApp.Model.Event.ShapeRealigned;
import CanvasApp.ViewModel.CanvasViewModel.Event.MouseEventStateChanged;
import CanvasApp.ViewModel.CanvasViewModel.Event.ShapeVMAdded;
import Observer.Observer;
import Observer.Event;
import CanvasApp.View.PropertyView.PropertyView;
import CanvasApp.ViewModel.CanvasViewModel.CanvasViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class CanvasView extends JPanel implements Observer {
    private final CanvasViewModel viewModel;

    private final JLayeredPane layeredPane = new JLayeredPane();
    private final JPanel glassPane = new JPanel();
    private final Map<Class<? extends Event<?>>, CanvasViewEventHandler> eventHandlers = new HashMap<>();

    public CanvasView(CanvasViewModel viewModel) {
        this.viewModel = viewModel;
        this.viewModel.attach(this);

        setLayout(new BorderLayout());
        initUI();
        initGlassPane();
        registerEventHandler();
    }

    private void initUI() {
        layeredPane.setPreferredSize(new Dimension(800, 600));
        layeredPane.setLayout(null);
        
        layeredPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (glassPane.isVisible()) {
                    return;
                }
                
                Component clickedComponent = layeredPane.findComponentAt(e.getPoint());
                if (clickedComponent == null || clickedComponent == layeredPane) {
                    new PressBackground(viewModel).execute();
                }
            }
        });
    }

    private void initGlassPane() {
        glassPane.setBounds(0, 0, layeredPane.getPreferredSize().width, layeredPane.getPreferredSize().height);
        glassPane.setOpaque(false);
        glassPane.setVisible(false);
        this.add(layeredPane);
        layeredPane.add(glassPane, JLayeredPane.DRAG_LAYER);

        glassPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
//                System.out.println("[CanvasView] mousePressed");
                (new PressMouse(viewModel,e)).execute();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                System.out.println("[CanvasView] mouseReleased");
                (new ReleaseMouse(viewModel,e)).execute();
            }
        });
    }

    private void registerEventHandler(){
        eventHandlers.put(ShapeVMAdded.class, new OnShapeAdded());
        eventHandlers.put(ShapeRealigned.class, new OnShapeRealigned());
        eventHandlers.put(MouseEventStateChanged.class, new OnMouseEventStateChanged());
    }

    @Override
    public void onUpdate(Event<?> event) {
//        System.out.println("[CanvasView] event.source : "+ event.source.getClass());
        CanvasViewEventHandler currentHandler = eventHandlers.get(event.getClass());
        if(currentHandler != null){
            currentHandler.handle(this,event);
        }
    }

    public void addChildViewOnLayeredPane(Component child){
        layeredPane.add(child);
        child.repaint();
//        System.out.println("[commit] newX : " + newX + ", newY : " + viewModel.getY());
    }

    public void removeChildViewOnLayeredPane(Component child) {
        layeredPane.remove(child);
    }

    public void setChildViewLayerOnLayeredPane(Component child,int layer){
        layeredPane.setLayer(child, layer);
    }

    public void setGlassPaneVisible(boolean isVisible){
        glassPane.setVisible(isVisible);
    }

    public Component findComponentById(String id) {
        for (Component comp : layeredPane.getComponents()) {
            if (id.equals(comp.getName())) {
                return comp;
            }
        }
        return null;
    }
}

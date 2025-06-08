package CanvasApp.View.CanvasView;

import CanvasApp.View.CanvasView.EventHandler.CanvasViewEventHandler;
import CanvasApp.View.CanvasView.EventHandler.OnShapeAdded;
import CanvasApp.View.CanvasView.EventHandler.OnShapeRealigned;
import CanvasApp.ViewModel.CanvasViewModel.Cmd.PressMouse;
import CanvasApp.ViewModel.CanvasViewModel.Cmd.ReleaseMouse;
import CanvasApp.Model.Event.ShapeRealigned;
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
    private final PropertyView propertyView;
    private final Map<Class<? extends Event<?>>, CanvasViewEventHandler> eventHandlers = new HashMap<>();

    public CanvasView(CanvasViewModel viewModel,PropertyView propertyView) {
        this.viewModel = viewModel;
        this.propertyView = propertyView;

        setLayout(new BorderLayout());
        initUI();
        initGlassPane();
        registerEventHandler();
    }

    private void initUI() {
        layeredPane.setPreferredSize(new Dimension(800, 600));
        layeredPane.setLayout(null);
        JScrollPane canvasScroll = new JScrollPane(layeredPane);

        JSplitPane splitPane = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                canvasScroll,
                propertyView
        );
        splitPane.setDividerLocation(800);
        splitPane.setResizeWeight(0.0);

        add(splitPane, BorderLayout.CENTER);
    }

    private void initGlassPane() {
        glassPane.setBounds(0, 0, layeredPane.getPreferredSize().width, layeredPane.getPreferredSize().height);
        glassPane.setOpaque(false);
        glassPane.setVisible(false);
        layeredPane.add(glassPane, JLayeredPane.DRAG_LAYER);  // add to drag layer

        glassPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                (new PressMouse(viewModel,e)).execute();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                (new ReleaseMouse(viewModel,e)).execute();
            }
        });
    }

    private void registerEventHandler(){
        eventHandlers.put(ShapeVMAdded.class, new OnShapeAdded());
        eventHandlers.put(ShapeRealigned.class, new OnShapeRealigned());
    }

    @Override
    public void onUpdate(Event<?> event) {
        CanvasViewEventHandler currentHandler = eventHandlers.get(event.getClass());
        if(currentHandler != null){
            currentHandler.handle(this,event);
        }
    }

    public void addChildViewOnLayeredPane(Component child){
        layeredPane.add(child);
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

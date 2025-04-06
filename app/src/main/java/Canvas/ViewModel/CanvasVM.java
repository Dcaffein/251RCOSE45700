package Canvas.ViewModel;

import Canvas.Domain.Command.ShapeCommand.CreateShapeCommand.CreateShapeCommand;
import Canvas.Domain.Observer.Observer;
import Canvas.Domain.Observer.Observable;
import Canvas.Domain.ShapeObject.ShapeObject;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class CanvasVM extends Observable implements Observer {
    private final Map<String, ShapeObject> shapes = new HashMap<>();

    public String createShape(CreateShapeCommand command) {
        return command.execute();
    }

    public void addShape(String id, ShapeObject shape) {
        shapes.put(id, shape);
    }

    public ShapeObject get(String id) {
        return shapes.get(id);
    }


    public void onUpdate(Object obj) {
        if (obj != null) {
            notifyObserver(obj.toString());
        }
    }

    public void draw(Graphics g, String id) {
        ShapeObject shape = get(id);
        if (shape != null && g != null) {
            shape.draw(g);
        }
    }

}

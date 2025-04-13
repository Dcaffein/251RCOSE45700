package Canvas.ViewModel;

import Canvas.Domain.Command.ShapeCommand.CreateShape.CreateShapeCommand;
import Canvas.Domain.Command.ShapeCommand.RenderShape.ShapeObjectEvent;
import Canvas.Domain.Observer.*;
import Canvas.Domain.ShapeObject.ShapeObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanvasVM extends ShapeObjectObservable implements ShapeObjectObserver {
    private final Map<String, ShapeObject> shapes = new HashMap<>();
    private final List<String> selected = new ArrayList<>();

    public String createShape(CreateShapeCommand command) {
        return command.execute();
    }

    public void addShape(String id, ShapeObject shape) {
        shapes.put(id, shape);
    }

    public ShapeObject get(String id) {
        return shapes.get(id);
    }

    @Override
    public void onUpdate(ShapeObjectEvent event) {
        notifyObservers(event);
    }

    public void draw(Graphics g,String id){
        get(id).draw(g);
    }

    public int getX(String id) {
        ShapeObject target = shapes.get(id);
        return target.getX();
    }
    public int getY(String id) {
        ShapeObject target = shapes.get(id);
        return target.getY();
    }
    public int getW(String id) {
        ShapeObject target = shapes.get(id);
        return target.getW();
    }
    public int getH(String id) {
        ShapeObject target = shapes.get(id);
        return target.getH();
    }

    public void deSelectAll(){
        selected.clear();
    }

    public void handleSelected(String id) {
        if (selected.contains(id)) {
            selected.remove(id);
        } else {
            selected.add(id);
        }

        // 로그 출력
        System.out.println("[Selected Shapes] " + selected);
    }

    public void move(int dx, int dy){
        for(String id : selected){
            get(id).move(dx, dy);
        }
    }

}

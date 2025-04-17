package Canvas.ViewModel;

import Canvas.Domain.Factory.ShapeFactory.ShapeFactory;
import Canvas.Domain.Observer.ShapeObjectEvent;
import Canvas.Domain.Observer.ShapeObjectObserver;
import Canvas.Domain.ShapeObject.ShapeObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanvasVM implements ShapeObjectObserver {
    private final Map<String, ShapeObject> shapes = new HashMap<>();
    private final List<String> selected = new ArrayList<>();
    private final Map<String, ShapeProp> shapeProps = new HashMap<>();
    private final List<String> zOrder = new ArrayList<>();

    public ShapeProp createShape(int x,int y,int w,int h, int z) {
        ShapeFactory shapeFactory = ShapeFactory.getInstance();
        ShapeObject shapeObject = shapeFactory.createShapeObject(x, y, w, h, z);
        ShapeProp shapeProp= shapeFactory.createShapeViewProps(shapeObject);

        shapeObject.attach(this);

        shapes.put(shapeObject.getId(), shapeObject);
        shapeProps.put(shapeObject.getId(), shapeProp);
        return shapeProp;
    }


    public ShapeObject get(String id) {
        return shapes.get(id);
    }

    @Override
    public void onUpdate(ShapeObjectEvent event) {
        ShapeProp targetView = shapeProps.get(event.id);
        ShapeObject targetModel = shapes.get(event.id);
        int x = targetModel.getX();
        int y = targetModel.getY();
        int w = targetModel.getW();
        int h = targetModel.getH();
        int z = targetModel.getZ();
        targetView.update(x, y,w,h, z);
    }

    private void deSelectAll(){
        selected.clear();
    }

    private void handleSelected(String id) {
        if (selected.contains(id)) {
            selected.remove(id);
        } else {
            selected.add(id);
        }

        System.out.println("[Selected Shapes] " + selected);
    }

    public void multiSelect(String id){
        handleSelected(id);
    }
    public void select(String id){
        deSelectAll();
        handleSelected(id);
    }

    public void move(int dx, int dy){
        for(String id : selected){
            get(id).move(dx, dy);
        }
    }
}

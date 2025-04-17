package Canvas.ViewModel;

import Canvas.Domain.Observer.ShapeObjectEvent;
import Canvas.Domain.Observer.ShapeObjectObservable;
import Canvas.Domain.Observer.ShapeObjectObserver;
import Canvas.Domain.ShapeObject.ShapeObject;


public abstract class ShapeProp extends ShapeObjectObservable implements ReadOnlyShapeProp {
    private final String id;
    private int x;
    private int y;
    private int w;
    private int h;
    private int z;
    private int padding = 2;

    public ShapeProp(ShapeObject shapeObject) {
        this.id = shapeObject.getId();
        this.x = shapeObject.getX();
        this.y = shapeObject.getY();
        this.w = shapeObject.getW();
        this.h = shapeObject.getH();
        this.z = shapeObject.getZ();
    }

    public void attachView(ShapeObjectObserver view) {
        super.attach(view);
    }

    public void update(int x, int y, int w, int h, int z) {
        setX(x);
        setY(y);
        setW(w);
        setH(h);
        System.out.printf(
                "[ShapeProp.update] id=%s | (x=%d, y=%d, w=%d, h=%d, z=%d) to (x=%d, y=%d, w=%d, h=%d, z=%d)\n",
                id,
                getX(), getY(), getW(), getH(), getZ(),  // 기존 값
                x, y, w, h, z                            // 갱신할 값
        );
        notifyObservers(new ShapeObjectEvent(id));
    }


    private void setX(int x) {
        this.x = x;
    }
    private void setY(int y) {
        this.y = y;
    }
    private void setW(int w) {
        this.w = w;
    }
    private void setH(int h) {
        this.h = h;
    }
    private void setZ(int z) {
        this.z = z;
    }
    private void setPadding(int padding) {
        this.padding = padding;
    }
    public String getId() {
        return id;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getW() {
        return w;
    }
    public int getH() {
        return h;
    }
    public int getZ() {
        return z;
    }
    public int getPadding() {
        return padding;
    }
}

package Canvas.Domain.Observer;

import java.util.List;
import java.util.ArrayList;


public abstract class ShapeObjectObservable {
    private final List<ShapeObjectObserver> observers = new ArrayList<>();

    public void attach(ShapeObjectObserver observer) {
        observers.add(observer);
    }

    public void detach(ShapeObjectObserver observer) {
        observers.remove(observer);
    }

    protected void notifyObservers(ShapeObjectEvent event) {
        for (ShapeObjectObserver observer : observers) {
            observer.onUpdate(event);
        }
    }
}
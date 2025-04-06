package Canvas.Domain.Observer;

import java.util.List;
import java.util.ArrayList;


public abstract class Observable {
    private final List<Observer> observers = new ArrayList<>();

    public void attach(Observer obs) {
        observers.add(obs);
    }

    public void detach(Observer obs) {
        observers.remove(obs);
    }

    public void notifyObserver(Object data) {
        for (Observer obs : observers) {
            obs.onUpdate(data);
        }
    }
}
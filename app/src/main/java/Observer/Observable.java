package Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    protected final List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void notify(Event<?> event) {
        List<Observer> snapshot = new ArrayList<>(observers);
        for (Observer o : snapshot) {
            o.onUpdate(event);
        }
    }
}
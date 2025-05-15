package Observer;

public abstract class Event<T> {
    public T source;
    public Event(T source) {
        this.source = source;
    }
    public abstract void dispatch(Observer o);
}
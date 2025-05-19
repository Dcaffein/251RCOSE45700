package Observer;

public interface EventHandlingStrategy<E extends Event<?>> {
    void handle(E event);
}

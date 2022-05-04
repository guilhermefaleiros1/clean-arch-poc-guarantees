package poc.com.quintoandar.guarantee.domain.base;

public interface EventHandler<T extends DomainEvent> {
    void handle(T event);
}

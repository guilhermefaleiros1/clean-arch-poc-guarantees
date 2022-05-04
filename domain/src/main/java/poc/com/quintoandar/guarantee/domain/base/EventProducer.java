package poc.com.quintoandar.guarantee.domain.base;

public interface EventProducer <T extends DomainEvent> {
    void publish(T event);
}

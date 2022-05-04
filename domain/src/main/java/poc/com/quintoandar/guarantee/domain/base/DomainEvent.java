package poc.com.quintoandar.guarantee.domain.base;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Data
public abstract class DomainEvent <T> {
    protected String id;
    protected T payload;

    protected DomainEvent(T payload) {
        this.id = UUID.randomUUID().toString();
        this.payload = payload;
    }

    protected DomainEvent(String id, T payload) {
        this.id = id;
        this.payload = payload;
    }
}

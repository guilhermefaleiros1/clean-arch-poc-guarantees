package poc.com.quintoandar.guarantee.domain.base;

public interface BaseService <T, R> {
    R execute(T input) throws DomainBusinessException;
}

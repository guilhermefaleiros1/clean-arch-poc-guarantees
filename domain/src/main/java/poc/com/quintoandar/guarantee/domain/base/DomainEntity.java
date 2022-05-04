package poc.com.quintoandar.guarantee.domain.base;

public abstract class DomainEntity {
    protected Long id;

    protected DomainEntity(Long id) {
        this.id = id;
    }

    protected DomainEntity() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

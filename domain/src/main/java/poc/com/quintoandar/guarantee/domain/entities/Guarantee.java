package poc.com.quintoandar.guarantee.domain.entities;

import lombok.Data;
import poc.com.quintoandar.guarantee.domain.base.DomainEntity;

import java.util.List;

@Data
public class Guarantee extends DomainEntity {
    private Double factor;
    private String name;
    private String externalCode;

    public Guarantee(Double factor, String name, String externalCode) {
        this.name = name;
        this.factor = factor;
        this.externalCode = externalCode;
    }

    public Guarantee(Long id, Double factor, String name, String externalCode) {
        super(id);
        this.name = name;
        this.factor = factor;
        this.externalCode = externalCode;
    }

    public Double getPreviewValue(Long baseValue) {
        return this.getFactor() * baseValue;
    }

    public Long calculateValue(Long baseValue) {
        return Double.valueOf(this.getFactor() * baseValue).longValue();
    }
}

package poc.com.quintoandar.guarantee.domain.entities;

import lombok.Data;
import poc.com.quintoandar.guarantee.domain.base.DomainBusinessException;
import poc.com.quintoandar.guarantee.domain.base.DomainEntity;

import java.util.List;

@Data
public class RiskCategory extends DomainEntity {
    private String description;
    private List<Guarantee> allowedGuarantees;

    public RiskCategory(String description, Double factor, List<Guarantee> allowedGuarantees) {
        this.description = description;
        this.allowedGuarantees = allowedGuarantees;
    }

    public RiskCategory(Long id, String description, List<Guarantee> allowedGuarantees) {
        super(id);
        this.description = description;
        this.allowedGuarantees = allowedGuarantees;
    }

    public Guarantee getGuaranteeEnabled(Long guaranteeId) throws DomainBusinessException {
        return this.allowedGuarantees
                .stream()
                .filter(guarantee -> guarantee.getId().equals(guaranteeId))
                .findFirst()
                .orElseThrow(() -> new DomainBusinessException("Esta categoria de risco não permite essa garantia!"));
    }

    public boolean isGuaranteeEnabled(Long guaranteeId) {
        return this.allowedGuarantees
                .stream()
                .anyMatch(guarantee -> guarantee.getId().equals(guaranteeId));
    }

}

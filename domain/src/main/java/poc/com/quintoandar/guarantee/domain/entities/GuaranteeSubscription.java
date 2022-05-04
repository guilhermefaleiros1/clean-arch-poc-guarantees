package poc.com.quintoandar.guarantee.domain.entities;

import lombok.Data;
import poc.com.quintoandar.guarantee.domain.base.DomainBusinessException;
import poc.com.quintoandar.guarantee.domain.base.DomainEntity;

@Data
public class GuaranteeSubscription extends DomainEntity {
    private Long userId;
    private Long value;
    private Long baseValue;
    private Guarantee guarantee;
    private Long documentationId;
    private GuaranteeSubscriptionStatus status;

    public GuaranteeSubscription(Long userId, Long baseValue, Guarantee guarantee, Long documentationId) {
        this.userId = userId;
        this.baseValue = baseValue;
        this.value = guarantee.calculateValue(baseValue);
        this.documentationId = documentationId;
        this.guarantee = guarantee;
        this.status = GuaranteeSubscriptionStatus.CREATED;
    }

    public GuaranteeSubscription(Long id, Long userId, Long baseValue, Guarantee guarantee,
                                 Long documentationId, GuaranteeSubscriptionStatus status) {
        super(id);
        this.userId = userId;
        this.baseValue = baseValue;
        this.value = guarantee.calculateValue(baseValue);
        this.documentationId = documentationId;
        this.guarantee = guarantee;
        this.status = status;
    }

    public void restoreGuarantee (Long baseValue, Guarantee guarantee) throws DomainBusinessException {
        if (this.getStatus().equals(GuaranteeSubscriptionStatus.PAID)) {
            throw new DomainBusinessException(403, "Não é possível alterar uma garantia paga.");
        }
        this.baseValue = baseValue;
        this.value = guarantee.calculateValue(baseValue);
        this.guarantee = guarantee;
        this.status = GuaranteeSubscriptionStatus.CREATED;
    }

}

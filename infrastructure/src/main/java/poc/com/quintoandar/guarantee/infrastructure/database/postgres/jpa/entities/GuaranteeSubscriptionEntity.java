package poc.com.quintoandar.guarantee.infrastructure.database.postgres.jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import poc.com.quintoandar.guarantee.domain.entities.GuaranteeSubscription;
import poc.com.quintoandar.guarantee.domain.entities.GuaranteeSubscriptionStatus;
import poc.com.quintoandar.guarantee.domain.entities.RiskCategory;

import javax.persistence.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "guarantee_subscriptions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GuaranteeSubscriptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "base_value")
    private Long baseValue;

    @Column
    private Long value;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "documentation_id")
    private Long documentationId;

    @ManyToOne
    @JoinColumn(name = "guarantee_id")
    private GuaranteeEntity guarantee;

    @Enumerated(EnumType.STRING)
    private GuaranteeSubscriptionStatus status;

    public GuaranteeSubscription toDomainEntity() {
        return new GuaranteeSubscription(this.id, this.userId, this.baseValue, this.guarantee.toDomainEntity(),
                this.documentationId, this.status);
    }

    public static GuaranteeSubscriptionEntity fromDomainEntity(GuaranteeSubscription subscription) {
        return GuaranteeSubscriptionEntity.builder()
                .id(subscription.getId())
                .value(subscription.getValue())
                .baseValue(subscription.getBaseValue())
                .userId(subscription.getUserId())
                .status(subscription.getStatus())
                .documentationId(subscription.getDocumentationId())
                .guarantee(GuaranteeEntity.fromDomainEntity(subscription.getGuarantee()))
                .build();
    }

}

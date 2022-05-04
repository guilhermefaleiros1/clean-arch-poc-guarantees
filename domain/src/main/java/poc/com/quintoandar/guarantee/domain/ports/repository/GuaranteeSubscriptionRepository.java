package poc.com.quintoandar.guarantee.domain.ports.repository;


import poc.com.quintoandar.guarantee.domain.entities.GuaranteeSubscription;

import java.util.List;
import java.util.Optional;

public interface GuaranteeSubscriptionRepository {
    GuaranteeSubscription save(GuaranteeSubscription subscription);
    Optional<GuaranteeSubscription> findByDocumentationId(Long documentationId);
    List<GuaranteeSubscription> findByUserId(Long documentationId);
    Optional<GuaranteeSubscription> findById(Long subscriptionId);
}

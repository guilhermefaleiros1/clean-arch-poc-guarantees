package poc.com.quintoandar.guarantee.infrastructure.database.postgres.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poc.com.quintoandar.guarantee.infrastructure.database.postgres.jpa.entities.GuaranteeSubscriptionEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpringDataGuaranteeSubscriptionRepository extends JpaRepository<GuaranteeSubscriptionEntity, Long> {
    Optional<GuaranteeSubscriptionEntity> findByDocumentationId (Long documentationId);
    List<GuaranteeSubscriptionEntity> findByUserId (Long userId);
}

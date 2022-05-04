package poc.com.quintoandar.guarantee.infrastructure.database.postgres.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import poc.com.quintoandar.guarantee.domain.entities.GuaranteeSubscription;
import poc.com.quintoandar.guarantee.domain.ports.repository.GuaranteeSubscriptionRepository;
import poc.com.quintoandar.guarantee.infrastructure.database.postgres.jpa.entities.GuaranteeSubscriptionEntity;
import poc.com.quintoandar.guarantee.infrastructure.database.postgres.jpa.repositories.SpringDataGuaranteeSubscriptionRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PostgresGuaranteeSubscriptionRepository implements GuaranteeSubscriptionRepository {

    @Autowired
    SpringDataGuaranteeSubscriptionRepository springGuaranteeSubscriptionRepository;

    @Override
    @CacheEvict(cacheNames =  { "GuaranteeSubscriptionByDocumentation", "GuaranteeSubscriptionByUser" },
            allEntries = true)
    public GuaranteeSubscription save(GuaranteeSubscription subscription) {
        var result = this.springGuaranteeSubscriptionRepository.save(
                GuaranteeSubscriptionEntity.fromDomainEntity(subscription)
        );
        subscription.setId(result.getId());
        return subscription;
    }

    @Override
    @Cacheable(cacheNames = "GuaranteeSubscriptionByDocumentation", key = "#documentationId", unless = "#result == null")
    public Optional<GuaranteeSubscription> findByDocumentationId(Long documentationId) {
        return this.springGuaranteeSubscriptionRepository.findByDocumentationId(documentationId)
                .map(GuaranteeSubscriptionEntity::toDomainEntity);
    }

    @Override
    @Cacheable(cacheNames = "GuaranteeSubscriptionByUser", key = "#userId")
    public List<GuaranteeSubscription> findByUserId(Long userId) {
        return this.springGuaranteeSubscriptionRepository.findByDocumentationId(userId)
                .stream()
                .map(GuaranteeSubscriptionEntity::toDomainEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<GuaranteeSubscription> findById(Long subscriptionId) {
        return this.springGuaranteeSubscriptionRepository.findById(subscriptionId)
                .map(GuaranteeSubscriptionEntity::toDomainEntity);
    }
}

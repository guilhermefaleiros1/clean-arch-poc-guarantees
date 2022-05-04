package poc.com.quintoandar.guarantee.infrastructure.database.postgres.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import poc.com.quintoandar.guarantee.domain.entities.RiskCategory;
import poc.com.quintoandar.guarantee.domain.ports.repository.RiskCategoryRepository;
import poc.com.quintoandar.guarantee.infrastructure.database.postgres.jpa.entities.RiskCategoryEntity;
import poc.com.quintoandar.guarantee.infrastructure.database.postgres.jpa.repositories.SpringDataRiskCategoryRepository;

import java.util.Optional;

@Repository
public class PostgresRiskCategoryRepository implements RiskCategoryRepository {

    @Autowired
    SpringDataRiskCategoryRepository springDataRiskCategoryRepository;

    @Override
    @Cacheable(cacheNames = "RiskCategory", key = "#riskId", unless = "#result == null")
    public Optional<RiskCategory> findById(Long riskId) {
        return this.springDataRiskCategoryRepository
                .findById(riskId)
                .map(RiskCategoryEntity::toDomainEntity);
    }
}

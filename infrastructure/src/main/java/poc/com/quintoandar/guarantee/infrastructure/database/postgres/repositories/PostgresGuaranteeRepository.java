package poc.com.quintoandar.guarantee.infrastructure.database.postgres.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import poc.com.quintoandar.guarantee.domain.entities.Guarantee;
import poc.com.quintoandar.guarantee.domain.ports.repository.GuaranteeRepository;
import poc.com.quintoandar.guarantee.infrastructure.database.postgres.jpa.entities.GuaranteeEntity;
import poc.com.quintoandar.guarantee.infrastructure.database.postgres.jpa.repositories.SpringDataGuaranteeRepository;

import java.util.Optional;

@Repository
public class PostgresGuaranteeRepository implements GuaranteeRepository {

    @Autowired
    private SpringDataGuaranteeRepository springGuaranteeRepository;

    @Override
    @Cacheable(cacheNames = "Guarantee", key = "#guaranteeId", unless = "#result == null")
    public Optional<Guarantee> findById(Long guaranteeId) {
        return this.springGuaranteeRepository
                .findById(guaranteeId)
                .map(GuaranteeEntity::toDomainEntity);
    }

    @Override
    @Cacheable(cacheNames = "Guarantee", key = "#externalCode", unless = "#result == null")
    public Optional<Guarantee> findByExternalCode(String externalCode) {
        return Optional.empty();
    }
}

package poc.com.quintoandar.guarantee.domain.ports.repository;

import poc.com.quintoandar.guarantee.domain.entities.RiskCategory;

import java.util.Optional;

public interface RiskCategoryRepository {
    Optional<RiskCategory> findById(Long riskId);
}

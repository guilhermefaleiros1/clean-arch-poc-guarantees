package poc.com.quintoandar.guarantee.infrastructure.database.postgres.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import poc.com.quintoandar.guarantee.infrastructure.database.postgres.jpa.entities.RiskCategoryEntity;

public interface SpringDataRiskCategoryRepository extends JpaRepository<RiskCategoryEntity, Long> {
}

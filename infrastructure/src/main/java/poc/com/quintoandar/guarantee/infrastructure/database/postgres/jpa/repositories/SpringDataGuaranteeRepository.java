package poc.com.quintoandar.guarantee.infrastructure.database.postgres.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import poc.com.quintoandar.guarantee.infrastructure.database.postgres.jpa.entities.GuaranteeEntity;

public interface SpringDataGuaranteeRepository extends JpaRepository<GuaranteeEntity, Long> {
}

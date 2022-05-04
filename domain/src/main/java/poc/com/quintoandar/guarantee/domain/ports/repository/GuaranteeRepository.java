package poc.com.quintoandar.guarantee.domain.ports.repository;

import poc.com.quintoandar.guarantee.domain.entities.Guarantee;

import java.util.Optional;

public interface GuaranteeRepository {
    Optional<Guarantee> findById(Long guaranteeId);
    Optional<Guarantee> findByExternalCode(String externalCode);
}

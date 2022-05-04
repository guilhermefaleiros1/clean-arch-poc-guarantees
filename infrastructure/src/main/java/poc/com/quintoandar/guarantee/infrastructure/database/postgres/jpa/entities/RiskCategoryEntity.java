package poc.com.quintoandar.guarantee.infrastructure.database.postgres.jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import poc.com.quintoandar.guarantee.domain.entities.RiskCategory;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "risk_categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RiskCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;

    @ManyToMany
    @JoinTable(
            name = "risk_categories_guarantees",
            joinColumns = @JoinColumn(name = "risk_category_id"),
            inverseJoinColumns = @JoinColumn(name = "guarantee_id"))
    private List<GuaranteeEntity> allowedGuarantees;

    public RiskCategory toDomainEntity() {
        var guarantees = this.getAllowedGuarantees()
                .stream()
                .map(GuaranteeEntity::toDomainEntity)
                .collect(Collectors.toList());
        return new RiskCategory(this.id, this.description, guarantees);
    }
}

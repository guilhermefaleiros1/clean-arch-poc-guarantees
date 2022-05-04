package poc.com.quintoandar.guarantee.infrastructure.database.postgres.jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import poc.com.quintoandar.guarantee.domain.entities.Guarantee;

import javax.persistence.*;

@Entity
@Table(name = "guarantees")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GuaranteeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double factor;

    @Column
    private String name;

    @Column(name = "external_code")
    private String externalCode;

    public Guarantee toDomainEntity() {
        return new Guarantee(this.id,  this.factor, this.name, this.externalCode);
    }

    public static GuaranteeEntity fromDomainEntity(Guarantee guarantee) {
        return GuaranteeEntity.builder()
                .externalCode(guarantee.getExternalCode())
                .factor(guarantee.getFactor())
                .id(guarantee.getId())
                .name(guarantee.getName())
                .build();
    }
}

package poc.com.quintoandar.guarantee.domain.usecases.getguaranteeavailable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetGuaranteesAvailableOutput {
    private Long guaranteeId;
    private String description;
    private Double value;
}

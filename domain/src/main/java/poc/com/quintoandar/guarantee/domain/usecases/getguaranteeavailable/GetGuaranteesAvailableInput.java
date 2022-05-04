package poc.com.quintoandar.guarantee.domain.usecases.getguaranteeavailable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetGuaranteesAvailableInput {
    private Long riskCategoryId;
    private Long baseValue;
}

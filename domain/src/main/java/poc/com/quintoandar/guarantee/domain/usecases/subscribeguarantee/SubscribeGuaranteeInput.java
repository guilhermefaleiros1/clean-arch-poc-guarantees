package poc.com.quintoandar.guarantee.domain.usecases.subscribeguarantee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubscribeGuaranteeInput {
    private Long userId;
    private Long value;
    private Long guaranteeId;
    private Long documentationId;
}

package poc.com.quintoandar.guarantee.domain.ports.integration.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCreditCardPaymentResponseDTO {
    private Long chargeId;
}

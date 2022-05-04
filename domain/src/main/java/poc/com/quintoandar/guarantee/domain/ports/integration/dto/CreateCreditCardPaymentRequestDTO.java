package poc.com.quintoandar.guarantee.domain.ports.integration.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCreditCardPaymentRequestDTO {
    private Long cardId;
    private BigDecimal value;
    private Integer installments;
    private String cardNumber;
    private Long userId;
    private String description;
    private String externalItemId;
    private String origin;
}

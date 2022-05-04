package poc.com.quintoandar.guarantee.domain.ports.integration;

import poc.com.quintoandar.guarantee.domain.base.BaseService;
import poc.com.quintoandar.guarantee.domain.ports.integration.dto.CreateCreditCardPaymentRequestDTO;
import poc.com.quintoandar.guarantee.domain.ports.integration.dto.CreateCreditCardPaymentResponseDTO;

public interface CreateCreditCardPayment extends BaseService<CreateCreditCardPaymentRequestDTO,
        CreateCreditCardPaymentResponseDTO> {
}

package poc.com.quintoandar.guarantee.presentation.exception;

import poc.com.quintoandar.guarantee.domain.base.DomainBusinessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DomainBusinessException.class)
    public ResponseEntity<ErrorMessageDTO> handleBusinessException(
            DomainBusinessException exception
    ) {
        return ResponseEntity
                .status(exception.getStatusCode())
                .body(new ErrorMessageDTO(exception.getMessage()));
    }
}

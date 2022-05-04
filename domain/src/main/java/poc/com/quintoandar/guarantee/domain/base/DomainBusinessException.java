package poc.com.quintoandar.guarantee.domain.base;

public class DomainBusinessException extends RuntimeException {
    private final Integer statusCode;
    private final String message;

    private static final String DEFAULT_ERROR_MESSAGE = "Domain Business Exception";
    private static final Integer DEFAULT_STATUS_CODE = 400;

    public DomainBusinessException(Integer statusCode, String message) {
        super(message);
        this.message = message;
        this.statusCode = statusCode;
    }

    public DomainBusinessException(String message) {
        super(message);
        this.message = message;
        this.statusCode = DEFAULT_STATUS_CODE;
    }

    public DomainBusinessException() {
        super(DEFAULT_ERROR_MESSAGE);
        this.message = DEFAULT_ERROR_MESSAGE;
        this.statusCode = DEFAULT_STATUS_CODE;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

package ir.safari.show.config.exception;

import lombok.Builder;

@Builder
public class ExceptionResponse {
    private final Short code;
    private final String message;
}

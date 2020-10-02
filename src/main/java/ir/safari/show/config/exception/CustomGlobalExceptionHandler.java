package ir.safari.show.config.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@RequiredArgsConstructor
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid
            (MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        Map<String, String> body = new HashMap<>();

        body.put("timestamp", new Date().toString());
        body.put("status", status.name());
        body.put("errors", ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> fieldError.getField() + " : " + fieldError.getDefaultMessage()).toString());

        return new ResponseEntity(body, headers, status);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleEntityNotFoundException(EntityNotFoundException ex) {
        ExceptionResponse response = ExceptionResponse
                .builder()
                .code((short) 1)
                .message(ex.getMessage())
                .build();
        return new ResponseEntity(response, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UniqueException.class)
    public ResponseEntity handleUniqueException(UniqueException ex) {
        return new ResponseEntity(ex.getMessage(), new HttpHeaders(), HttpStatus.CONFLICT);
    }

}

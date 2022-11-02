package pl.losiek.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiExceptionBody> handleApiException(ApiException ex) {
        ApiExceptionBody body = new ApiExceptionBody(
                ex.getStatus(),
                ex.getMessage()
        );

        return new ResponseEntity<>(body, ex.getStatus());
    }
}

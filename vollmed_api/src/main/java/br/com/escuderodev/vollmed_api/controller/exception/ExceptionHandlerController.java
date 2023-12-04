package br.com.escuderodev.vollmed_api.controller.exception;

import br.com.escuderodev.vollmed_api.models.StandardError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ExceptionHandlerController {

    private StandardError standardError = new StandardError();

    @ExceptionHandler(NotFoundExceptionController.class)
    public ResponseEntity<StandardError> entityNotFoundException(NotFoundExceptionController e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        standardError.setTimestamp(Instant.now());
        standardError.setStatus(status.value());
        standardError.setError("Entity not found!");
        standardError.setMessage(e.getMessage());
        standardError.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(this.standardError);
    }
}

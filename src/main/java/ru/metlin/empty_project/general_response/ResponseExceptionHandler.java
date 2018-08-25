package ru.metlin.empty_project.general_response;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.metlin.empty_project.general_response.ErrorView;

@RestControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ErrorView handlingException(RuntimeException e) {

        return new ErrorView(e.getMessage());
    }
}

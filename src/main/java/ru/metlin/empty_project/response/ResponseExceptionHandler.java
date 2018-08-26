package ru.metlin.empty_project.response;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResponseExceptionHandler {

    private final Logger logger = Logger.getLogger(ResponseExceptionHandler.class);

    @ExceptionHandler(RuntimeException.class)
    public ErrorView handlingException(RuntimeException e) {

        logger.error(e.toString());
        return new ErrorView(e.getMessage());
    }
}

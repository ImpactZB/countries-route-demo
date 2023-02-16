package com.impactzb.countriesroutedemo.exception.handler;

import com.impactzb.countriesroutedemo.dto.ProblemDetails;
import com.impactzb.countriesroutedemo.exception.RouteException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    public static final String BAD_REQUEST_TITLE = "Bad Request";

    @ExceptionHandler({RouteException.class})
    public ResponseEntity<Object> handleApiBadRequestException(final Exception ex) {
        log.error("Exception thrown", ex);
        RouteException appException = (RouteException) ex;
        ProblemDetails problemDetails = ProblemDetails.builder()
                .status(HttpStatus.BAD_REQUEST)
                .title(BAD_REQUEST_TITLE)
                .details(List.of(appException.getLocalizedMessage()))
                .build();
        return new ResponseEntity<>(problemDetails, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}

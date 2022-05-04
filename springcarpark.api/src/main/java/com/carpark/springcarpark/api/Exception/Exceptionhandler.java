package com.carpark.springcarpark.api.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;


@ControllerAdvice
public class Exceptionhandler {


    @ExceptionHandler(value = {NotFoundException.class, DuplicatedException.class, TripCapabilityException.class})
    public ResponseEntity<Object> handleRuntimeException(RuntimeException r) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        //1.Create body for exception
        ApiException apiException = new ApiException(
                r.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))

        );
        return new ResponseEntity<>(apiException, badRequest);
    }

    @ExceptionHandler(value = {Throwable.class})
    public ResponseEntity<Object> handleOtherException(Exception e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        //1.Create body for exception
        ApiException apiException = new ApiException(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))

        );
        return new ResponseEntity<>(apiException, badRequest);
    }
}

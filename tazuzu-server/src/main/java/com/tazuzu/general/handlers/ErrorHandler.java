package com.tazuzu.general.handlers;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.Objects;

@SuppressWarnings("unused")
@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleViolationException(DataIntegrityViolationException e) {

        Throwable t = e.getRootCause();
        if ( t instanceof MySQLIntegrityConstraintViolationException ) {
            MySQLIntegrityConstraintViolationException mysqlException = (MySQLIntegrityConstraintViolationException) t;
            switch(mysqlException.getErrorCode()) {
                case 1062:
                    return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        }

        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleNotFound(EntityNotFoundException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

package com.snmi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    private static final String MESSAGE = "Account with id=%s isn't found";

    public NotFoundException(Long id) {
        super(String.format(MESSAGE, id));
    }

}

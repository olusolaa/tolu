package com.ems.employeemanagementsystem.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UserUnauthorised extends RuntimeException {

    private static final long serialVersionUID= 6467910063316359195L;
    public UserUnauthorised (String message) {
        super(message);
    }
}

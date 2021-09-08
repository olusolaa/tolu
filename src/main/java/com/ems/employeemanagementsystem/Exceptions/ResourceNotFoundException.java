package com.ems.employeemanagementsystem.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 7743280755349941363L;
    public ResourceNotFoundException (String message) {
        super(message);
    }
}

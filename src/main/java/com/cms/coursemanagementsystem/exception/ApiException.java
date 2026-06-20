package com.cms.coursemanagementsystem.exception;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {
    private final HttpStatus httpStatus;

    /**
     * Constructs a new ApiException.
     * @param message The detailed message explaining the error.
     * @param httpStatus The HTTP status code associated with this error (e.g., 404 NOT_FOUND).
     */
    public ApiException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
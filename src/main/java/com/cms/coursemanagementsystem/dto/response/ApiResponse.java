package com.cms.coursemanagementsystem.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

// Use @JsonInclude to exclude null fields from the JSON output when they are not set (e.g., data/errors)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResponse<T>(
        int status,
        boolean success,
        String message,
        T data // This can hold actual success data or detailed error data (like a Map of validation errors)
) {
    /** Creates a simple error response. */
    public static <T> ApiResponse<T> error(int status, String message) {
        return new ApiResponse<>(status, false, message, null);
    }

    /** Creates an error response with detailed data (e.g., validation errors). */
    public static <T> ApiResponse<T> error(int status, String message, T data) {
        return new ApiResponse<>(status, false, message, data);
    }

    /** Creates a success response. */
    public static <T> ApiResponse<T> success(int status, String message, T data) {
        return new ApiResponse<>(status, true, message, data);
    }
}
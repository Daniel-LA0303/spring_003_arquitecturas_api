package com.mx.soap.service.api.soap.enums;

public enum ServiceStatusEnum {
    SUCCESS("Success", "The operation completed successfully."),
    ERROR("Error", "An error occurred during the operation."),
    NOT_FOUND("Not Found", "The requested resource could not be found."),
    INVALID_REQUEST("Invalid Request", "The request was invalid or malformed."),
    UNAUTHORIZED("Unauthorized", "The request is not authorized.");

    private final String status;
    private final String message;

    ServiceStatusEnum(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}

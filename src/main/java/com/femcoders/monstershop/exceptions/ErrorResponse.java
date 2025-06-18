package com.femcoders.monstershop.exceptions;

public class ErrorResponse {
    private String message;
    private int status;
    private String errorCode;
    private String timestamp;

    public ErrorResponse(String message, int status, String errorCode, String timestamp) {
        this.message = message;
        this.status = status;
        this.errorCode = errorCode;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getTimestamp() {
        return timestamp;
    }
}

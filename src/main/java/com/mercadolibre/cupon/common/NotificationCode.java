package com.mercadolibre.cupon.common;

import org.springframework.http.HttpStatus;

public enum NotificationCode {
    EMPTY_ARRAY("this array is empty", HttpStatus.FORBIDDEN);


    private String description;
    private HttpStatus httpStatus;

    NotificationCode(String description, HttpStatus httpStatus) {
        this.description = description;
        this.httpStatus = httpStatus;
    }

    public String getDescription() {
        return description;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}

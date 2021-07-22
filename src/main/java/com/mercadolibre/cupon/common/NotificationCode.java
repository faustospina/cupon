package com.mercadolibre.cupon.common;

import org.springframework.http.HttpStatus;

public enum NotificationCode {
    /**
     * se mapea los elementos con referencia a una descripcion y a status
     */
    NOT_FOUND_ENTITY("Not found entity by id", HttpStatus.FORBIDDEN),
    INSUFFICIENT_AMOUNT("Insufficient amount available", HttpStatus.FORBIDDEN);


    private String description;
    private HttpStatus httpStatus;

    /**
     * constructor del enum
     * @param description
     * @param httpStatus
     */
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

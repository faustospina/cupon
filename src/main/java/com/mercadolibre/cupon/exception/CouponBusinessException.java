package com.mercadolibre.cupon.exception;

import com.mercadolibre.cupon.common.NotificationCode;

import java.io.Serializable;

public class CouponBusinessException extends RuntimeException implements Serializable {
    private final NotificationCode errorCode;


    /**
     * constructor de la clase manejo de excepciones
     *
     * @param message
     * @param errorCode
     */
    public CouponBusinessException(String message, NotificationCode errorCode) {
        super(errorCode.getDescription());
        this.errorCode = errorCode;
    }


    public NotificationCode getErrorCode() {
        return errorCode;
    }
}

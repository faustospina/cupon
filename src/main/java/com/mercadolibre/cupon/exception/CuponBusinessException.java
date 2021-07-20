package com.mercadolibre.cupon.exception;

import com.mercadolibre.cupon.common.NotificationCode;

import java.io.Serializable;

public class CuponBusinessException extends Exception implements Serializable {
    private final NotificationCode errorCode;


    public CuponBusinessException(NotificationCode errorCode) {
        super(errorCode.getDescription());
        this.errorCode = errorCode;
    }

    public NotificationCode getErrorCode() {
        return errorCode;
    }
}

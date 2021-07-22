package com.mercadolibre.cupon.service;

import com.mercadolibre.cupon.dto.ItemOut;
import com.mercadolibre.cupon.dto.ItemsInOut;
import com.mercadolibre.cupon.exception.CouponBusinessException;

public interface CouponService {

    ItemsInOut getItems(ItemsInOut items) throws CouponBusinessException;

    ItemOut getItem(String code) throws CouponBusinessException;

}

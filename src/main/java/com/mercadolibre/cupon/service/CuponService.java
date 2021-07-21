package com.mercadolibre.cupon.service;

import com.mercadolibre.cupon.dto.ItemOut;
import com.mercadolibre.cupon.dto.ItemsInOut;
import com.mercadolibre.cupon.exception.CuponBusinessException;

public interface CuponService {

    ItemsInOut getItems(ItemsInOut items);

    ItemOut getItem(String code) throws CuponBusinessException;

}

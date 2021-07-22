package com.mercadolibre.cupon.service;

import com.mercadolibre.cupon.dto.ItemOut;
import com.mercadolibre.cupon.dto.ItemsInOut;
import com.mercadolibre.cupon.exception.CouponBusinessException;

/**
 * servicio para la logica de negocion
 */
public interface CouponService {

    /**
     *
     * @param items
     * @return la lista de items filtrados por el amount
     * @throws CouponBusinessException
     */
    ItemsInOut getItems(ItemsInOut items) throws CouponBusinessException;

    /**
     *
     * @param item_id
     * @return el objeto que se busca en la base de datos por el item_id
     * @throws CouponBusinessException
     */
    ItemOut getItem(String item_id) throws CouponBusinessException;

}

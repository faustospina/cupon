package com.mercadolibre.cupon.service;

import com.mercadolibre.cupon.entity.ItemEntity;
import com.mercadolibre.cupon.exception.CouponBusinessException;

import java.util.List;

public interface ItemService {

    /**
     *
     * @param items
     * @return busca y devuelve los elementos con coincidencias en la base de datos
     */
    List<ItemEntity> getItems(List<String> items);

    /**
     *
     * @param id
     * @return busca y devuelve el objeto de la base de datos
     * @throws CouponBusinessException
     */
    ItemEntity getItem(String id) throws CouponBusinessException;

}

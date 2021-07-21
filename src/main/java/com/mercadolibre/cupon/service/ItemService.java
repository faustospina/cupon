package com.mercadolibre.cupon.service;

import com.mercadolibre.cupon.entity.ItemEntity;
import com.mercadolibre.cupon.exception.CuponBusinessException;

import java.util.List;

public interface ItemService {

    List<ItemEntity> getItems(List<String> items);

    ItemEntity getItem(String id) throws CuponBusinessException;

}

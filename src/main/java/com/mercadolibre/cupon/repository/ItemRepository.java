package com.mercadolibre.cupon.repository;

import com.mercadolibre.cupon.entity.ItemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<ItemEntity, String> {

    /**
     * @param items
     * @return obtiene los elemento que esten en la lista
     */
    List<ItemEntity> getItemEntityByItemIdIn(List<String> items);

    /**
     * @param id
     * @return obtiene el elemento por id
     */
    ItemEntity getById(String id);

}

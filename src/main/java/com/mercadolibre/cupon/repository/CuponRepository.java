package com.mercadolibre.cupon.repository;

import com.mercadolibre.cupon.entity.ItemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CuponRepository extends CrudRepository<ItemEntity,String> {

    List<ItemEntity> getCuponEntitiesByItemIdIn(List<String> items);

    ItemEntity getById(String id);

}

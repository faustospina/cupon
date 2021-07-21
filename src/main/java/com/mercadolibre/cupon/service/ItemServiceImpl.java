package com.mercadolibre.cupon.service;

import com.mercadolibre.cupon.common.NotificationCode;
import com.mercadolibre.cupon.entity.ItemEntity;
import com.mercadolibre.cupon.exception.CuponBusinessException;
import com.mercadolibre.cupon.repository.CuponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{

    private final CuponRepository cuponRepository;




    @Override
    public List<ItemEntity> getItems(List<String> items) {
        return cuponRepository.getCuponEntitiesByItemIdIn(items);
    }

    @Override
    public ItemEntity getItem(String id) {
           return cuponRepository.getById(id);
    }



}

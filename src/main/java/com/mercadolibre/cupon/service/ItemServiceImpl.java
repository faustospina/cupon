package com.mercadolibre.cupon.service;

import com.mercadolibre.cupon.entity.ItemEntity;
import com.mercadolibre.cupon.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;


    /**
     * @param items
     * @return busca y devuelve los elementos con coincidencias en la base de datos
     */
    @Override
    public List<ItemEntity> getItems(List<String> items) {
        return itemRepository.getItemEntityByItemIdIn(items);
    }

    /**
     * @param id
     * @return busca y devuelve el objeto de la base de datos
     */
    @Override
    public ItemEntity getItem(String id) {
        return itemRepository.getById(id);
    }


}

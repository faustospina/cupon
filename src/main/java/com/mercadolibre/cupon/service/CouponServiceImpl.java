package com.mercadolibre.cupon.service;

import com.mercadolibre.cupon.common.NotificationCode;
import com.mercadolibre.cupon.dto.ItemOut;
import com.mercadolibre.cupon.dto.ItemsInOut;
import com.mercadolibre.cupon.entity.ItemEntity;
import com.mercadolibre.cupon.exception.CouponBusinessException;
import com.mercadolibre.cupon.mapper.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;

@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService {

    private final ItemService itemService;
    private final ItemMapper itemMapper;
    private double temp = 0.0;


    @Override
    public ItemsInOut getItems(ItemsInOut items) throws CouponBusinessException {
        temp=0.0;
        ItemsInOut itemsOuts = new ItemsInOut();
        itemsOuts.setItems(new ArrayList<>());
        itemService.getItems(items.getItems())
                .stream()
                .sorted(Comparator.comparing(ItemEntity::getPrice))
                .forEach(a -> calculate(itemsOuts, items.getAmount(), a));
        return itemsOuts;
    }

    private void calculate(ItemsInOut itemsOut, Double amount, ItemEntity itemEntity) throws CouponBusinessException {
        temp += itemEntity.getPrice();
        if (itemEntity.getPrice()>amount&&itemsOut.getItems().isEmpty()){
            throw new CouponBusinessException("Insufficient amount available",NotificationCode.INSUFFICIENT_AMOUNT);
        }
        if(temp <= amount) {
            itemsOut.getItems().add(itemEntity.getItemId());
            itemsOut.setAmount(temp);
        }

    }

    @Override
    public ItemOut getItem(String code) throws CouponBusinessException {
        try {
            return itemMapper.itemEntityToDto(itemService.getItem(code));
        } catch (Throwable c) {
            throw new CouponBusinessException(c.getMessage(), NotificationCode.NOT_FOUND_ENTITY);
        }
    }


}

package com.mercadolibre.cupon.service;


import com.mercadolibre.cupon.common.NotificationCode;
import com.mercadolibre.cupon.dto.ItemOut;
import com.mercadolibre.cupon.dto.ItemsInOut;
import com.mercadolibre.cupon.entity.ItemEntity;
import com.mercadolibre.cupon.exception.CouponBusinessException;
import com.mercadolibre.cupon.mapper.ItemMapper;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CouponServiceImplTest {

    @Mock
    private ItemServiceImpl itemService;

    @Mock
    private ItemMapper itemMapper;

    @InjectMocks
    private CouponServiceImpl couponService;

    private ItemEntity responseEntity(){
        ItemEntity itemEntity1= new ItemEntity();
        itemEntity1.setItemId("MLA1");
        itemEntity1.setId("MLA1");
        itemEntity1.setTitle("Item De Test");
        itemEntity1.setPrice(100.0);

        return itemEntity1;

    }

    private ItemOut responseDtoOut(){
        ItemOut itemOut= new ItemOut();
        itemOut.setItemId("MLA1");
        itemOut.setId("MLA1");
        itemOut.setTitle("Item De Test");
        itemOut.setPrice(100.0);
        return itemOut;
    }

    private ItemsInOut requestGetItems(){
        ItemsInOut item = new ItemsInOut();
        item.setItems(new ArrayList<>());
        item.getItems().add("MLA1");
        item.getItems().add("MLA2");
        item.getItems().add("MLA3");
        item.getItems().add("MLA4");
        item.getItems().add("MLA5");
        item.setAmount(500.0);
        return item;
    }

    private ItemsInOut requestGetItemsMinvalue(){
        ItemsInOut item = new ItemsInOut();
        item.setItems(new ArrayList<>());
        item.getItems().add("MLA1");
        item.getItems().add("MLA2");
        item.getItems().add("MLA3");
        item.getItems().add("MLA4");
        item.getItems().add("MLA5");
        item.setAmount(70.0);
        return item;
    }

    private List<ItemEntity> responseGetItems(){
        List<ItemEntity> itemsEntity = new ArrayList<>();

        ItemEntity itemEntity1= new ItemEntity();
        itemEntity1.setItemId("MLA1");
        itemEntity1.setId("MLA1");
        itemEntity1.setTitle("Item De Test");
        itemEntity1.setPrice(100.0);

        ItemEntity itemEntity2= new ItemEntity();
        itemEntity2.setItemId("MLA2");
        itemEntity2.setId("MLA2");
        itemEntity2.setTitle("Item De Test");
        itemEntity2.setPrice(210.0);

        ItemEntity itemEntity3= new ItemEntity();
        itemEntity3.setItemId("MLA3");
        itemEntity3.setId("MLA3");
        itemEntity3.setTitle("Item De Test");
        itemEntity3.setPrice(260.0);

        ItemEntity itemEntity4= new ItemEntity();
        itemEntity4.setItemId("MLA4");
        itemEntity4.setId("MLA4");
        itemEntity4.setTitle("Item De Test");
        itemEntity4.setPrice(80.0);

        ItemEntity itemEntity5= new ItemEntity();
        itemEntity5.setItemId("MLA5");
        itemEntity5.setId("MLA5");
        itemEntity5.setTitle("Item De Test");
        itemEntity5.setPrice(90.0);

        itemsEntity.add(itemEntity1);
        itemsEntity.add(itemEntity2);
        itemsEntity.add(itemEntity3);
        itemsEntity.add(itemEntity4);
        itemsEntity.add(itemEntity5);

        return itemsEntity;
    }




    @Test
    public void getItems() {
        Mockito.when(itemService.getItems(requestGetItems().getItems())).thenReturn(responseGetItems());
        ItemsInOut itemsInOut=couponService.getItems(requestGetItems());
        Assertions.assertTrue(itemsInOut!=null);
        Assertions.assertTrue(itemsInOut.getAmount()==480.0);
    }

    @Test(expected = CouponBusinessException.class)
    public void getItemsException() {
        Mockito.when(itemService.getItems(requestGetItemsMinvalue().getItems())).thenReturn(responseGetItems());
        ItemsInOut itemsInOut=couponService.getItems(requestGetItemsMinvalue());
        Assertions.assertTrue(itemsInOut!=null);
    }

    @Test
    public void getItem() {
        Mockito.when(itemService.getItem("MLA1")).thenReturn(responseEntity());
        Mockito.when(itemMapper.itemEntityToDto(responseEntity())).thenReturn(responseDtoOut());
        ItemOut itemOut=couponService.getItem("MLA1");
        Assertions.assertTrue(itemOut!=null);
    }

    @Test(expected = CouponBusinessException.class)
    public void getItemException() throws CouponBusinessException {
        Mockito.when(itemService.getItem("MLA1"))
                .thenThrow(new CouponBusinessException("Not found entity by id",NotificationCode.NOT_FOUND_ENTITY));
        ItemOut itemOut=couponService.getItem("MLA1");
        Assertions.assertTrue(itemOut!=null);
    }
}
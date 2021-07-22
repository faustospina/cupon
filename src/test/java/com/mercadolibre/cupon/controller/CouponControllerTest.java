package com.mercadolibre.cupon.controller;

import com.mercadolibre.cupon.common.NotificationCode;
import com.mercadolibre.cupon.dto.ItemOut;
import com.mercadolibre.cupon.dto.ItemsInOut;
import com.mercadolibre.cupon.exception.CouponBusinessException;
import com.mercadolibre.cupon.service.CouponService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class CouponControllerTest {

    @Mock
    private CouponService couponService;

    @InjectMocks
    private CouponController couponController;

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

    private ItemsInOut requestGetItemsMinValue(){
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

    private ItemsInOut responseGetItems(){
        ItemsInOut item = new ItemsInOut();
        item.setItems(new ArrayList<>());
        item.getItems().add("MLA1");
        item.getItems().add("MLA2");
        item.getItems().add("MLA3");
        item.getItems().add("MLA4");
        item.getItems().add("MLA5");
        item.setAmount(480.0);
        return item;
    }



    @Test
    public void validateCoupon() {
        Mockito.when(couponService.getItems(requestGetItems())).thenReturn(responseGetItems());
        ResponseEntity<ItemsInOut> responseEntity = (ResponseEntity<ItemsInOut>) couponController.validateCoupon(requestGetItems());
        Assertions.assertTrue(responseEntity.getBody().getAmount()==480.0);
    }

    @Test
    public void validateCouponException() {
        Mockito.when(couponService.getItems(requestGetItemsMinValue())).thenThrow(new CouponBusinessException("Insufficient amount available",NotificationCode.INSUFFICIENT_AMOUNT));
        ResponseEntity<ItemsInOut> responseEntity = (ResponseEntity<ItemsInOut>) couponController.validateCoupon(requestGetItemsMinValue());
        Assertions.assertTrue(responseEntity.getStatusCode() == HttpStatus.FORBIDDEN);
    }

    @Test
    public void getItem() {
        Mockito.when(couponService.getItem("MLA1")).thenReturn(responseDtoOut());
        ResponseEntity<ItemOut> responseEntity = (ResponseEntity<ItemOut>) couponController.getItem("MLA1");
        Assertions.assertTrue(responseEntity.getBody()!=null);
    }

    @Test
    public void getItemException() throws CouponBusinessException {
        Mockito.when(couponService.getItem("MLA8")).thenThrow(new CouponBusinessException("Not found entity by id",NotificationCode.NOT_FOUND_ENTITY));
        ResponseEntity<ItemOut> responseEntity = (ResponseEntity<ItemOut>) couponController.getItem("MLA8");
        Assertions.assertTrue(responseEntity.getStatusCode() == HttpStatus.FORBIDDEN);
    }
}
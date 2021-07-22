package com.mercadolibre.cupon.controller;

import com.mercadolibre.cupon.dto.ItemsInOut;
import com.mercadolibre.cupon.exception.CouponBusinessException;
import com.mercadolibre.cupon.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CouponController {

    @Autowired
    private CouponService couponService;


    @PostMapping(path = "/coupon", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> isMutant(@RequestBody ItemsInOut item) throws CouponBusinessException {
        try {
            return new ResponseEntity<>(couponService.getItems(item), HttpStatus.OK);
        } catch (CouponBusinessException c) {
            return new ResponseEntity<>(c.getMessage(), c.getErrorCode().getHttpStatus());
        }

    }

    @GetMapping(path = "/items/{item_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getItem(@PathVariable String item_id){
        try {
            return new ResponseEntity<>(couponService.getItem(item_id), HttpStatus.OK);
        } catch (CouponBusinessException c) {
            return new ResponseEntity<>(c.getMessage(), c.getErrorCode().getHttpStatus());
        }

    }




}

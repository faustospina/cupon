package com.mercadolibre.cupon.controller;

import com.mercadolibre.cupon.dto.ItemsInOut;
import com.mercadolibre.cupon.exception.CuponBusinessException;
import com.mercadolibre.cupon.service.CuponService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CuponController {

    @Autowired
    private CuponService cuponService;


    @PostMapping(path = "/coupon", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemsInOut isMutant(@RequestBody ItemsInOut item) {
        return cuponService.getItems(item);
    }

    @GetMapping(path = "/items/{item_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getItem(@PathVariable String item_id){
        try {
            return new ResponseEntity<>(cuponService.getItem(item_id), HttpStatus.OK);
        } catch (CuponBusinessException c) {
            return new ResponseEntity<>(c.getMessage(), c.getErrorCode().getHttpStatus());
        }

    }




}

package com.mercadolibre.cupon.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemOut {
    private String itemId;
    private String id;
    private String title;
    private Double price;
}

package com.mercadolibre.cupon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemOut {
    private String itemId;
    private String id;
    private String title;
    private Double price;
}

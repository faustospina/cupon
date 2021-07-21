package com.mercadolibre.cupon.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@RequiredArgsConstructor
public class ItemsInOut {

    @NotEmpty
    @NotNull
    @Size
    private List<String> items;

    @NotEmpty
    @NotNull
    private Double amount;
}

package com.mercadolibre.cupon.mapper;

import com.mercadolibre.cupon.dto.ItemOut;
import com.mercadolibre.cupon.entity.ItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ItemMapper {

    ItemOut itemEntityToDto(ItemEntity item);


}

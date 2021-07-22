package com.mercadolibre.cupon.mapper;

import com.mercadolibre.cupon.dto.ItemOut;
import com.mercadolibre.cupon.entity.ItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ItemMapper {

    /**
     * intefaz que convierte de una entidad tipo item a un dto item
     *
     * @param item
     * @return
     */
    ItemOut itemEntityToDto(ItemEntity item);


}

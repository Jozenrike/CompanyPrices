package com.example.ComparnyPrices.application.mapper;

import com.example.ComparnyPrices.entities.Prices;
import com.example.infrastructure.controller.model.PriceResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel= "spring")
public interface PricesMapper {

    @Mapping(qualifiedByName = "getPriceFromPriceAndCurr", target = "price", source = "priceEntity")
    PriceResponseDTO mapEntityToDto(Prices priceEntity);

    @Named("getPriceFromPriceAndCurr")
    default String getPrice(Prices priceEntity){
        return priceEntity.getPrice() + priceEntity.getCurr();
    }

}

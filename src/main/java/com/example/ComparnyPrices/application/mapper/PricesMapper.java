package com.example.ComparnyPrices.application.mapper;

import com.example.ComparnyPrices.entities.Prices;
import com.example.infrastructure.controller.model.PriceResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.OffsetDateTime;
import java.util.Date;

@Mapper(componentModel= "spring")
public interface PricesMapper {

    @Mapping(qualifiedByName = "getPriceFromPriceAndCurr", target = "price", source = "priceEntity")
    PriceResponseDTO mapEntityToDto(Prices priceEntity);

    @Mapping(expression = "java(setDate(applyDate, true))", target = "startDate")
    @Mapping(expression = "java(setDate(applyDate, false))", target = "endDate")
    Prices mapDtoToEntity(final Integer productId, final Integer brandId, final OffsetDateTime applyDate);

    @Named("getPriceFromPriceAndCurr")
    default String getPrice(Prices priceEntity){
        return priceEntity.getPrice() + priceEntity.getCurr();
    }

    default Date setDate(OffsetDateTime applyDate, boolean isStart){
        return new Date();
    }

}

package com.example.CompanyPrices.application.mapper;

import com.example.CompanyPrices.domain.entity.Prices;
import com.example.infrastructure.controller.model.PriceResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

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

    default OffsetDateTime setDate(OffsetDateTime applyDate, boolean isStart){
        return LocalDateTime.now().atOffset(ZoneOffset.UTC);
    }

    default String setDate(OffsetDateTime date){
        return date.toString();
    }

}

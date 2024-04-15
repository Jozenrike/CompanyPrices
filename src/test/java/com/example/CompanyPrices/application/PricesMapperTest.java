package com.example.CompanyPrices.application;

import com.example.CompanyPrices.application.mapper.PricesMapper;
import com.example.CompanyPrices.domain.entity.Prices;
import com.example.infrastructure.controller.model.PriceResponseDTO;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.assertj.core.api.Assertions.assertThat;


public class PricesMapperTest {

    private final EasyRandom generator = new EasyRandom();

    private final PricesMapper pricesMapper = Mappers.getMapper(PricesMapper.class);

    private static final int PRODUCT_ID = 1;
    private static final int BRAND_ID = 1;
    private static final OffsetDateTime OFFSET_DATE_TIME = LocalDateTime.now().withYear(2024).withMonth(5).withDayOfMonth(1).atOffset(ZoneOffset.UTC);

    @Test
    void whenMapDtoToEntityIsCalled_thenReturnEntityObject(){
        Prices price = pricesMapper.mapDtoToEntity(PRODUCT_ID, BRAND_ID, OFFSET_DATE_TIME);

        assertThat(price.getBrandId()).isEqualTo(PRODUCT_ID);
        assertThat(price.getProductId()).isEqualTo(BRAND_ID);
    }


    @Test
    void whenMapEntityToDtoIsCalled_thenReturnResponseDto(){
        Prices price = generator.nextObject(Prices.class);
        PriceResponseDTO priceResponseDTO = pricesMapper.mapEntityToDto(price);

        assertThat(priceResponseDTO.getBrandId()).isEqualTo(price.getBrandId());
        assertThat(priceResponseDTO.getProductId()).isEqualTo(price.getProductId());
        assertThat(priceResponseDTO.getPriceList()).isEqualTo(price.getPriceList());
        assertThat(priceResponseDTO.getStartDate()).isEqualTo(price.getStartDate().toString());
        assertThat(priceResponseDTO.getEndDate()).isEqualTo(price.getEndDate().toString());
        assertThat(priceResponseDTO.getPrice()).isEqualTo(price.getPrice() + price.getCurr());
    }

}

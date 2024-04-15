package com.example.CompanyPrices.application;

import com.example.CompanyPrices.application.service.PricesService;
import com.example.CompanyPrices.domain.entity.Prices;
import com.example.CompanyPrices.domain.repository.PricesRepository;
import com.example.infrastructure.controller.model.PriceResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PricesServiceTest {

    @Autowired
    private PricesService pricesService;
    @Autowired
    private PricesRepository pricesRepository;
    private static final int PRODUCT_ID = 1;
    private static final int BRAND_ID = 1;
    public static final String FOUND_PRICE = "15.35";
    public static final String FOUND_EUR = "EUR";
    private static final OffsetDateTime OFFSET_DATE_TIME = LocalDateTime.now().withYear(2024).withMonth(5).withDayOfMonth(1).atOffset(ZoneOffset.UTC);


    @BeforeEach
    void setUp(){
        pricesRepository.save(Prices.builder().brandId(BRAND_ID).productId(PRODUCT_ID).priceList(1).price("25.11").curr(FOUND_EUR).priority(2).startDate(OFFSET_DATE_TIME.minusDays(1)).endDate(OFFSET_DATE_TIME.plusDays(1)).build());
        pricesRepository.save(Prices.builder().brandId(BRAND_ID).productId(PRODUCT_ID).priceList(2).price(FOUND_PRICE).curr(FOUND_EUR).priority(1).startDate(OFFSET_DATE_TIME.minusDays(1)).endDate(OFFSET_DATE_TIME.plusDays(1)).build());
    }

    @Test
    void whenFindingPriceExists_thenRetrieveData() {
        PriceResponseDTO foundPrice = pricesService.searchPrice(PRODUCT_ID, BRAND_ID, OFFSET_DATE_TIME);

        assertThat(foundPrice).isNotNull();
        assertThat(foundPrice.getBrandId()).isEqualTo(BRAND_ID);
        assertThat(foundPrice.getProductId()).isEqualTo(PRODUCT_ID);
        assertThat(foundPrice.getPriceList()).isEqualTo(2);
        assertThat(foundPrice.getPrice()).isEqualTo(FOUND_PRICE + FOUND_EUR);
    }

    @Test
    void whenFindingPriceFilterNotInBetweenDates_thenReturnEmpty() {
       PriceResponseDTO foundPrice = pricesService.searchPrice(PRODUCT_ID, BRAND_ID, OFFSET_DATE_TIME.minusDays(3));
       assertThat(foundPrice).isNull();
    }

    @Test
    void whenFindingPriceFilterIncorrectProducId_thenReturnEmpty() {
        PriceResponseDTO foundPrice = pricesService.searchPrice(PRODUCT_ID, BRAND_ID + 1, OFFSET_DATE_TIME);
        assertThat(foundPrice).isNull();
    }

    @Test
    void whenFindingPriceFilterIncorrectBrandId_thenReturnEmpty() {
        PriceResponseDTO foundPrice = pricesService.searchPrice(PRODUCT_ID + 2, BRAND_ID, OFFSET_DATE_TIME);
        assertThat(foundPrice).isNull();
    }
}

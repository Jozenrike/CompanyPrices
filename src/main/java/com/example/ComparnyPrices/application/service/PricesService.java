package com.example.ComparnyPrices.application.service;

import com.example.ComparnyPrices.application.mapper.PricesMapper;
import com.example.ComparnyPrices.entities.Prices;
import com.example.ComparnyPrices.infrastructure.repository.PricesRepository;
import com.example.infrastructure.controller.model.PriceResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class PricesService {

    private final PricesMapper pricesMapper;
    private final PricesRepository pricesRepository;

    public PriceResponseDTO searchPrice(final Integer productId, final Integer brandId, final OffsetDateTime applyDate) {
        final Prices prices = pricesMapper.mapDtoToEntity(productId, brandId, applyDate);
        return pricesMapper.mapEntityToDto(findPrice(prices));
    }

    private Prices findPrice(final Prices prices) {
        return pricesRepository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                prices.getProductId(),
                prices.getBrandId(),
                prices.getStartDate(),
                prices.getEndDate()
        );
    }
}

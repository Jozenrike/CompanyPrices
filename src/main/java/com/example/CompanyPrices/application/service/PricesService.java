package com.example.CompanyPrices.application.service;

import com.example.CompanyPrices.application.mapper.PricesMapper;
import com.example.CompanyPrices.infrastructure.repository.PricesRepository;
import com.example.infrastructure.controller.model.PriceResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class PricesService {

    private final PricesMapper pricesMapper;
    private final PricesRepository pricesRepository;

    public PriceResponseDTO searchPrice(final Integer productId, final Integer brandId, final OffsetDateTime applyDate) {
        return pricesMapper.mapEntityToDto(pricesRepository.findByFilters(productId, brandId, applyDate));
    }

}

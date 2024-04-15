package com.example.CompanyPrices.application.service;

import com.example.CompanyPrices.application.mapper.PricesMapper;
import com.example.CompanyPrices.domain.entity.Prices;
import com.example.CompanyPrices.domain.repository.PricesRepository;
import com.example.CompanyPrices.infrastructure.exception.ResourceNotFoundException;
import com.example.infrastructure.controller.model.PriceResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PricesService {

    private final PricesMapper pricesMapper;
    private final PricesRepository pricesRepository;

    public PriceResponseDTO searchPrice(final Integer productId, final Integer brandId, final OffsetDateTime applyDate) {
        Prices price = pricesRepository.findByFilters(productId, brandId, applyDate);
        if(Objects.isNull(price))
            throw new ResourceNotFoundException();
        return pricesMapper.mapEntityToDto(price);
    }

}

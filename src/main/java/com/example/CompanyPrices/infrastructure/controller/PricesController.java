package com.example.CompanyPrices.infrastructure.controller;

import com.example.CompanyPrices.application.service.PricesService;
import com.example.infrastructure.controller.api.PricesApi;
import com.example.infrastructure.controller.model.PriceResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
@RequiredArgsConstructor
public class PricesController implements PricesApi {

    private final PricesService pricesService;

    @Override
    public ResponseEntity<PriceResponseDTO> searchPrice(final Integer productId, final Integer brandId, final OffsetDateTime applyDate) {
        return ResponseEntity.status(HttpStatus.OK).body(pricesService.searchPrice(productId, brandId, applyDate));
    }
}

package com.example.ComparnyPrices.infrastructure.controller;

import com.example.infrastructure.controller.api.PricesApi;
import com.example.infrastructure.controller.model.PriceResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
@RequiredArgsConstructor
public class PostsController implements PricesApi {

    @Override
    public ResponseEntity<PriceResponseDTO> searchPrice(Integer productId, Integer brandId, OffsetDateTime applyDate) {
        return null;
    }
}

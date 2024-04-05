package com.example.ComparnyPrices.application.service;

import com.example.ComparnyPrices.application.mapper.PricesMapper;
import com.example.ComparnyPrices.infrastructure.repository.PricesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PricesService {

    private final PricesMapper pricesMapper;
    private final PricesRepository pricesRepository;

}

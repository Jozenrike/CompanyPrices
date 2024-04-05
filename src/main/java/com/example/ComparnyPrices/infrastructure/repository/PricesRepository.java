package com.example.ComparnyPrices.infrastructure.repository;

import com.example.ComparnyPrices.entities.Prices;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricesRepository extends CrudRepository<Prices, String> {
}
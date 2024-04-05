package com.example.ComparnyPrices.infrastructure.repository;

import com.example.ComparnyPrices.entities.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface PricesRepository extends JpaRepository<Prices, String> {

    Prices findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(int productId, int brandId, Date startDate, Date endDate);

}
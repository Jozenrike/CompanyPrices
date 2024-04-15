package com.example.CompanyPrices.domain.repository;

import com.example.CompanyPrices.domain.entity.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;

@Repository
public interface PricesRepository extends JpaRepository<Prices, String> {

    @Query(value = "SELECT p FROM Prices p " +
            "WHERE p.productId = :productId " +
            "AND p.brandId = :brandId " +
            "AND :applyDate BETWEEN p.startDate AND p.endDate " +
            "GROUP BY p.productId " +
            "HAVING p.priority = (SELECT MIN(p.priority) FROM Prices p " +
            "            WHERE p.productId = :productId " +
            "            AND p.brandId = :brandId)"
    )
    Prices findByFilters(
            @Param("productId") int productId,
            @Param("brandId") int brandId,
            @Param("applyDate") OffsetDateTime applyDate);
}
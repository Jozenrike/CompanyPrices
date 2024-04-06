package com.example.CompanyPrices.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.OffsetDateTime;

@Entity
@Table(name= "PRICES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Prices {

    @NotNull
    private int brandId;

    @NotNull
    private OffsetDateTime startDate;

    @NotNull
    private OffsetDateTime endDate;

    @NotNull
    private int priceList;

    @Id
    private int productId;

    @NotNull
    private int priority;

    @NotNull
    private String price;

    @NotNull
    private String curr;

}

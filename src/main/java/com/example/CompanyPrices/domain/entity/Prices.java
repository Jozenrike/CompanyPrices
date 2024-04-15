package com.example.CompanyPrices.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Generated;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name= "PRICES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Prices {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    private int brandId;

    @NotNull
    private OffsetDateTime startDate;

    @NotNull
    private OffsetDateTime endDate;

    @NotNull
    private int priceList;

    @NotNull
    private int productId;

    @NotNull
    private int priority;

    @NotNull
    private String price;

    @NotNull
    private String curr;

}

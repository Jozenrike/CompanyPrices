package com.example.ComparnyPrices.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Entity
@Table(name= "PRICES")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Prices {

    @NotNull
    private int brandId;

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;

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
